package Mavenprojects.MAVEN1;





//import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

//import io.restassured.http.ContentType;
//import io.restassured.internal.assertion.Assertion;

public class ReadJSONExample {

    public ReadJSONExample() {
        // TODO Auto-generated constructor stub
    }

    
        @SuppressWarnings("unchecked")
        public static void main(String[] args) 
        {
            //JSON parser object to parse read file
            JSONParser jsonParser = new JSONParser();
             
            try {
            FileReader reader = new FileReader("C:\\Users\\saita\\Desktop\\Manju Workspace\\employees.json");
            
                //Read JSON file
                Object obj = jsonParser.parse(reader);
                float j=90.99f;
     int k= (int)j;
                JSONArray employeeList = (JSONArray) obj;
                System.out.println(employeeList.get(2));// Object
                System.out.println(employeeList.size());
                 
                //Iterate over employee array
               // for(Object emp:employeeList)
               // {
                    parseEmployeeObject((JSONObject)employeeList.get(2) );
              //  }
               // employeeList.forEach( emp -> parseEmployeeObject( (JSONObject) emp ) );
     
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
     
        private static void parseEmployeeObject(JSONObject employee) 
        {
            System.out.println(employee.get("Department"));
            //Get employee object within list
            JSONObject employeeObject = (JSONObject) employee.get("employee");
        
            //Get employee first name
            String firstName = (String) employeeObject.get("firstName");    
            System.out.println(firstName);
             
            //Get employee last name
            String lastName = (String) employeeObject.get("lastName");  
            System.out.println(lastName);
//assertThat.body("places[0].'place name'", equalTo("Beverly Hills"));
           
             
            //Get employee website name
            String website = (String) employeeObject.get("website");    
            System.out.println(website);
            
            //Get employee Mobile number
            String mobilenumber = (String) employeeObject.get("mobilenumber");    
            System.out.println(mobilenumber);
            System.out.println(employeeObject.size());
        }
}
