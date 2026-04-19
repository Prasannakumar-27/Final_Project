package utilities;

import java.io.File;

import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

public class JsonReader {

    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            // Read JSON file
            JsonNode rootNode = mapper.readTree(new File("testData.json"));

            
            JsonNode HpNode = rootNode.get("HomePage");
            
            String location = HpNode.get("location").asText();
            String hospitalSearch = HpNode.get("hospitalSearch").asText();

            // Read nested object
            JsonNode cwNode = rootNode.get("corporateWellness");

            String name = cwNode.get("cw_name").asText();
            String org = cwNode.get("cw_org").asText();
            String mobile = cwNode.get("cw_mobile").asText();
            String email = cwNode.get("cw_email").asText();
            String orgSize = cwNode.get("cw_org_size").asText();
            String interest = cwNode.get("cw_interest").asText();

            // Print values
//            System.out.println("Location: " + location);
//            System.out.println("Hospital Search: " + hospitalSearch);
//            System.out.println("CW Name: " + name);
//            System.out.println("CW Org: " + org);
//            System.out.println("CW Mobile: " + mobile);
//            System.out.println("CW Email: " + email);
//            System.out.println("CW Org Size: " + orgSize);
//            System.out.println("CW Interest: " + interest);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}