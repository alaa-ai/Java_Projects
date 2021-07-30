package demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class WuzzufController  {
    WuzzufServiceDAO service = new WuzzufServiceDAO();
    @GetMapping("/getData")
    public String getData(Model model)
    {
        List<Pojo> data=service.convertData();
        model.addAttribute("datalist",data);
        return "list-data";
    }
     @GetMapping("/summary")
    public  String  show_summary(Model theModel){
        theModel.addAttribute("summ",service.summary());
        return "summary";
    }

     @GetMapping("/structure")
    public  String  show_structure(Model theModel){
        theModel.addAttribute("schema",service.structure());
        return "schema";
    }
    
    @GetMapping("/getVectorData")
    public String getFactorizadData(Model model)
    {
        List<Pojo> data=service.factorizeYearsExp();
        model.addAttribute("datalist",data);
        return "list-vector-data";
    }
    @GetMapping("/getPredictions")
    public String getPrediction(Model model)
    {
        Map<String,Long> data=service.clusterData();
        model.addAttribute("predictions",data);
        return "predictions";
    }
    //getting top companies final version
    @GetMapping("/topcompanies")
    public String topCompanies(Model theModel)
    {
         Map<String,Long> data= service.calculateFrequency("Company");
        theModel.addAttribute("companies",data);
        return "list-top-companies";
    }
    //Showing Top Area
    @GetMapping("/topareas")
    public String topAreas(Model theModel)
    {
        Map<String,Long> data= service.calculateFrequency("Location");
        theModel.addAttribute("locations",data);
        return "list-top-areas";
    }
    //Showing Top Titles
    @GetMapping("/toptitles")
    public String topTitles(Model theModel)
    {
        Map<String,Long> data= service.calculateFrequency("Title");
        theModel.addAttribute("titles",data);
        return "list-top-titles";
    }
    @GetMapping("/topskills")
    public String topSkills(Model theModel)
    {
        Map<String,Long> data= service.getCommonSkills();
        theModel.addAttribute("skills",data);
        return "list-top-skills";
    }
    @GetMapping("/plottopcompanies")
    public String plotGraphs(Model theModel)
    {
      service.DisplayMostDemandingCompanies();
        return "charts";
    }
    @GetMapping("/plot1")
    public String plotGraphs1(Model theModel)
    {

        return "charts1";
    }
    @GetMapping("/plotcommontitles")
    public String plotGraphs2(Model theModel)
    {
       service.DisplayMostPopularJobTitles();
        return "charts2";
    }
    @GetMapping("/plot3")
    public String plotGraphs3(Model theModel)
    {
        return "charts3";
    }

    @GetMapping("/commonareas")
    public String plotBarChart(Model theModel)
    {
         service.DisplayMostPopularAreas();
        return "popularAreas";
    }


}
