import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
    public static void main(String[] args)
    {
    Scanner reader = new Scanner(System.in);
    Path workingDirectory = Paths.get(".").toAbsolutePath();
    String newdir = (workingDirectory + "\\jobs.txt");
    String FILENAME = newdir;
    BufferedWriter bw = null;
    FileWriter fw = null;
    boolean error = false;
        try{
        fw = new FileWriter(newdir, true);
        bw = new BufferedWriter(fw);
         }catch (IOException e) {
         e.printStackTrace();
        }
        boolean cont = true;
        int color1 = 0;
        int color2 = 0;
        int color3 = 0;
        int totalWeps = 0;
        int modelnum = 0;
        int hp = 0;
        int max = 0;
    while(cont)
        {
             //String test = name.replaceAll("[^a-zA-Z]", "");
            String name = "";
            List<String> weps = new ArrayList<String>();
            List<String> models = new ArrayList<String>();
            System.out.println("Enter the class name: ");
            name = reader.nextLine();
            System.out.println("Enter the Team and command name, \n(should be first letter or number spelled out of each word): ");
            String teamcom = reader.nextLine();
            String command = teamcom.toLowerCase();
            String teamname = teamcom.toUpperCase();
            do{
                System.out.println("Enter the first color number: ");
                String color1s = reader.nextLine();
                try{
                    color1 = Integer.parseInt(color1s);
                }catch(NumberFormatException e){
                        error = true;
                        System.out.println("Error Please Re-enter.");
                }
            }while(error);
            
            System.out.println("Enter the second color number: ");
            color2 = reader.nextInt();
            System.out.println("Enter the thrid color number: ");
            color3 = reader.nextInt();
            reader.nextLine();
            System.out.println("Enter the number of class models to be added: ");
            modelnum = reader.nextInt();
            reader.nextLine();
             for(int i = 0; i < modelnum; i++)
            {
                System.out.println("Enter model number " + (i+1) + " for the class:");
                models.add(reader.nextLine());
            }
            System.out.println("Enter the class description: ");
            String desc = reader.nextLine();
            System.out.println("Enter the total number of weapons for the class: ");
            totalWeps = reader.nextInt();
            reader.nextLine();
            for(int i = 0; i < totalWeps; i++)
            {
                System.out.println("Enter weapon number " + (i+1) + " for the class:");
                weps.add(reader.nextLine());
            }
            System.out.println("Enter the category the class belongs in: ");
            String category = reader.nextLine();
            System.out.println("Enter the total amount of health for the class: ");
            hp = reader.nextInt();
            System.out.println("Enter the maximum amount of players that should be able to be,\nthis job at once (0 is infinite): ");
            max = reader.nextInt();
            reader.nextLine();
        try {
            bw.write("TEAM_" + teamname + " = DarkRP.createJob(\"" + name + "\", {\n"); 
            bw.write("\tcolor = Color(" + color1 + ", " + color2 + ", " + color3 + ", 255),\n"); 
            bw.write("\tmodel = {\n");
            for(int i = 0; i < models.size(); i++)
            {
                bw.write("\t\t\"" + models.get(i) + "\",\n");
            }
            bw.write("\t },\n");
            bw.write("\tdescription = [[" + desc + "]],\n");
            bw.write("\tweapons = {");
            for(int i = 0; i < weps.size(); i++)
            {
                bw.write("\"" + weps.get(i) + "\", ");
            }
            bw.write("\"" + weps.get(weps.size()-1) + "\"},\n");
            bw.write("\tcommand = \"" + command + "\",\n");
            bw.write("\tmax = " + max +",\n");
            bw.write("\tsalary = 100,\n");
            bw.write("\tadmin = 0,\n");
            bw.write("\tvote = false,\n");
            bw.write("\thasLicense = true,\n");
            bw.write("\tcandemote = false,\n");
            bw.write("\tcategory = \"" + category + "\",\n");
            bw.write("\tammo = {\n\t\t[\"AR2\"] = 2000\n\t},\n");
            bw.write("\tPlayerLoadout = function(ply)\n\t\tGAMEMODE:SetPlayerSpeed(ply, GAMEMODE.Config.walkspeed * 1.0, GAMEMODE.Config.runspeed * 1.0)\n");
            bw.write("\t\tply:SetMaxHealth(" + hp + ")\n");
            bw.write("\t\tply:SetHealth(" + hp + ")\n");
            bw.write("\t\tply:SetArmor(20)\n");
            bw.write("\tend\n");
            bw.write("})\n");
            bw.write("\n");
            System.out.println("Done");
        } catch (IOException e) {
    
            e.printStackTrace();
    
        }
        System.out.println("Do you want to do another job? (Y or N)");
        String conthelp = reader.nextLine();
        if(conthelp.toLowerCase().equals("n") || conthelp.toLowerCase().equals("no"))
            cont = false;
        else
            cont = true;
        }
    try{
    bw.close();
    fw.close();
    }catch (IOException e){
        e.printStackTrace();
    }
}
}
