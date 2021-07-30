package demo.controller;

import org.apache.spark.api.java.function.FilterFunction;
import org.apache.spark.ml.clustering.KMeans;
import org.apache.spark.ml.clustering.KMeansModel;
import org.apache.spark.ml.feature.OneHotEncoder;
import org.apache.spark.ml.feature.StringIndexer;
import org.apache.spark.ml.feature.VectorAssembler;
import org.apache.spark.sql.*;
import org.apache.spark.sql.types.StructType;
import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.apache.spark.ml.feature.OneHotEncoder;
import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

import static org.apache.spark.sql.functions.col;
import static org.apache.spark.sql.functions.explode;
import static org.apache.spark.sql.functions.*;
public class WuzzufServiceDAO {
    public DataFrameReader getFrameReader(){
        final SparkSession session = SparkSession.builder().appName("CSV analasis").master("local[*]").getOrCreate();
        return session.read();
    }
    public SparkSession getFrameRead(){
        final SparkSession session = SparkSession.builder().appName("CSV analasis").master("local[*]").getOrCreate();
        return session;
    }

    public Dataset<Row> getDataset() {
        Dataset<Row> data = getFrameReader().option("header", "true").csv("src\\main\\resources\\wuzzufjobs.csv");
        data = data.dropDuplicates().na().drop().filter((FilterFunction<Row>) row -> !row.get(5).equals("null Yrs of Exp"));
        return data;
    }

    Dataset<Row> data = getDataset();
    public List<Pojo> convertData()
    {
        List<Row> data1=data.collectAsList();
        List<Pojo> mydata=new ArrayList<>();
        List<Pojo> lastdata=new ArrayList<>();
        for (Row row:data1)
        {
            mydata.add(new Pojo(row.get(0).toString(),row.get(1).toString(),row.getString(2),row.get(3).toString(),row
                    .getString(4),row.get(5).toString(),row.getString(6),row.getString(7)));
        }
        for(int i=0;i<20;i++)
        {
            lastdata.add(mydata.get(i));
        }
        return lastdata;
    }
    
   public List<Row> summary() {

        Dataset<Row> d = data.summary();
        List<Row> summary = d.collectAsList();
        return summary;
    }
  
   
    public String structure(){
        StructType datas = data.schema();
        return datas.prettyJson();
    }

   public Map<String,Long> calculateFrequency(String feature){
        Dataset<Row> groupeddata = data.groupBy(feature).count().orderBy(col("count").desc()).limit(30);
        List<String> Names=groupeddata.select(feature).limit(40).as(Encoders.STRING()).collectAsList();
        List<Long> count= groupeddata.select("count").limit(40).as(Encoders.LONG()).collectAsList();
        Map<String,Long> groupedData=new LinkedHashMap<>();
        for(int i=0;i<count.size();i++){
            groupedData.put(Names.get(i),count.get(i));
        }
        return groupedData;
    }
    public Map<String,Long> getCommonSkills()
    {
        Dataset<Row> popularSkills=data.select(explode(split(col("Skills"),",")).as("skills")).groupBy("skills").count().orderBy(col("count").desc());
        List<String> skills=popularSkills.select("skills").limit(40).as(Encoders.STRING()).collectAsList();
        List<Long> count= popularSkills.select("count").limit(40).as(Encoders.LONG()).collectAsList();
        Map<String,Long> grouped_Data=new LinkedHashMap<>();    // linked hashmap preserves order
        for(int i=0;i<count.size();i++)
        {
            grouped_Data.put(skills.get(i),count.get(i));
        }
        return grouped_Data;
    }
    //display pie chart of the most popular jobs
    public void DisplayMostDemandingCompanies() {
        Dataset<Row> groupeddata = data.groupBy("Company").count().orderBy(col("count").desc()).limit(30);
        List<String> names=groupeddata.select("Company").limit(10).as(Encoders.STRING()).collectAsList();
        List<Long> count= groupeddata.select("count").limit(10).as(Encoders.LONG()).collectAsList();
        // Create Chart
        PieChart chart = new PieChartBuilder().width (1000).height (800).title ("Most Demonding companies").build ();
        Color[] sliceColors=new Color[]{new Color(224, 68, 14), new Color(230, 105, 62), new Color(236, 143, 110), new Color(243, 180,20),
                new Color(180,68,50),new Color(130,105,120),new Color(80,143,160)};
        chart.getStyler().setSeriesColors(sliceColors);

        // Series
        for (int i=0 ; i<names.size();i++){
            chart.addSeries(names.get(i), count.get(i));
        }
       try{
           BitmapEncoder.saveBitmap(chart, "src/main/resources/static/images/count_Companies", BitmapEncoder.BitmapFormat.PNG);
       } catch(IOException ex){
           ex.printStackTrace();
       }
    }
    //
    //display bar chart of the most popular job Titles
    public void DisplayMostPopularJobTitles()
    {
        Dataset<Row> groupeddata = data.groupBy("Title").count().orderBy(col("count").desc()).limit(30);
        List<String> names=groupeddata.select("Title").limit(10).as(Encoders.STRING()).collectAsList();
        List<Long> count= groupeddata.select("count").limit(10).as(Encoders.LONG()).collectAsList();
        CategoryChart chart = new CategoryChartBuilder().width (1024).height (600).title ("Most Popular Job Title").xAxisTitle("Job Title").yAxisTitle("Count jobs").build ();
        // 2.Customize Chart
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
        chart.getStyler().setHasAnnotations(true);
        chart.getStyler().setStacked(true);
        chart.getStyler().setXAxisLabelRotation(90);
        // 3.Series
        chart.addSeries("Job Title", names, count);
        try
        {
            BitmapEncoder.saveBitmap(chart, "src/main/resources/static/images/popularTitles", BitmapEncoder.BitmapFormat.PNG);
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }
    //display bar chart of the most popular Areas
    public void DisplayMostPopularAreas()
    {
        Dataset<Row> topAreas = data.groupBy("Location").count().orderBy(col("count").desc()).limit(30);
        List<String> nameOfArea = topAreas.select("Location").limit(10).as(Encoders.STRING()).collectAsList();
        List<Long> countArea= topAreas.select("count").limit(10).as(Encoders.LONG()).collectAsList();
        CategoryChart chart = new CategoryChartBuilder().width (1024).height (600).title ("Most Popular Areas").xAxisTitle("Area").yAxisTitle("Count").build ();
        // 2.Customize Chart
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
        chart.getStyler().setHasAnnotations(true);
        chart.getStyler().setStacked(true);
        chart.getStyler().setXAxisLabelRotation(45);
        // 3.Series
        chart.addSeries("Locations", nameOfArea, countArea);
        try
        {
            BitmapEncoder.saveBitmap(chart, "src/main/resources/static/images/popularAreas", BitmapEncoder.BitmapFormat.PNG);
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }
    //my functions above
    public List<Pojo>  factorizeYearsExp()
    {
      //  Dataset<Row> cleanData =  cleanData();
        // step 1 : indexing
        StringIndexer yearsexp=new StringIndexer();
        yearsexp.setInputCol("YearsExp");
        yearsexp.setOutputCol("YearsExpIND");
        Dataset<Row> dataVect=yearsexp.fit(data).transform(data);
        //  dataVect.show();
        // step 2: one hot encoding
        List<Row> data1=dataVect.collectAsList();
        List<Pojo> mydata=new ArrayList<>();
        List<Pojo> lastdata=new ArrayList<>();
        for (Row row:data1)
        {
            mydata.add(new Pojo(row.get(0).toString(),row.get(1).toString(),row.getString(2),row.get(3).toString(),row
                    .getString(4),row.get(5).toString(),row.getString(6),row.getString(7),row.get(8).toString()));
        }
        for(int i=0;i<20;i++)
        {
            lastdata.add(mydata.get(i));
        }
        return lastdata;

    }
    //task 12
    private Dataset<Row> getFeatures ()
    {

        StringIndexer titleIndex=new StringIndexer();
        titleIndex.setInputCol("Title");
        titleIndex.setOutputCol("titleIndex");

        Dataset<Row> cleanData_1=titleIndex.fit(data).transform(data);

        //indexing companies
        StringIndexer companyIndex=new StringIndexer();
        companyIndex.setInputCol("Company");
        companyIndex.setOutputCol("companyIndex");
        Dataset<Row> cleanData_2=companyIndex.fit(cleanData_1).transform(cleanData_1);
        //vecto assembler
        VectorAssembler vectorAssembler=new VectorAssembler();
        Dataset<Row> inputData=vectorAssembler.setInputCols(new String[]{"titleIndex","companyIndex"}).setOutputCol("features").transform(cleanData_2);
               // .select("features");
        return inputData;
    }
    public Map<String,Long> clusterData() {
        Dataset<Row> factorizedData = getFeatures();
        Dataset<Row> dataModel = getFeatures().select("features");
        KMeans kmeans=new KMeans();
        kmeans.setK(7);
        KMeansModel model=kmeans.fit(dataModel);
        Dataset<Row> predictions=model.transform(dataModel);
        Column prediction=predictions.col("prediction");
        // Dataset<Row> newDs = factorizedData.withColumn("cluster Number",predictions.col("prediction"));
       // System.out.println("SSe is "+model.getMaxIter(dataModel));
        Dataset<Row> groupedPredictions=predictions.groupBy("prediction").count();
        List<String> clusterNumber=groupedPredictions.select("prediction").as(Encoders.STRING()).collectAsList();
        List<Long> count= groupedPredictions.select("count").as(Encoders.LONG()).collectAsList();
        Map<String,Long> groupedData=new LinkedHashMap<>();
        for(int i=0;i<count.size();i++){
            groupedData.put(clusterNumber.get(i),count.get(i));
        }
        return groupedData;
    }

}

