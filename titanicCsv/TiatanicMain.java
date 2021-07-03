/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package titanicCsv;

import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.formula.functions.Column;
import tech.tablesaw.api.Table;
import tech.tablesaw.io.DataFrameReader;


/**
 *
 * @author gt
 */
public class TiatanicMain {
     public static void main(String[] args) throws IOException{
         Table titanicData;
         String dataPath = "D:\\1st-AI- ITI\\Javz\\Day5\\Data_to_use\\titanic.csv";
         titanicData = Table.read().csv(dataPath);
         
         List<tech.tablesaw.columns.Column<?>> dataStructure = titanicData.columns();
         
         System.out.println(dataStructure);
         
         System.out.println(titanicData.summary());
     }
}
