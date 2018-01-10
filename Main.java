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
    try{
    fw = new FileWriter(newdir);
    bw = new BufferedWriter(fw);
    }catch (IOException e) {
         e.printStackTrace();
        }
        boolean cont = true;
        while(cont)
        {
            List<String> weps = new ArrayList<String>();
            System.out.println("Enter the class name: ");
            String name = reader.nextLine();
            System.out.println("Enter the first color number: ");
            int color1 = reader.nextInt();
            System.out.println("Enter the second color number: ");
            int color2 = reader.nextInt();
            System.out.println("Enter the thrid color number: ");
            int color3 = reader.nextInt();
            reader.nextLine();
            System.out.println("Enter the class model: ");
            String model = reader.nextLine();
            System.out.println("Enter the class description: ");
            String desc = reader.nextLine();
            System.out.println("Enter the total number of weapons for the class: ");
            int totalWeps = reader.nextInt();
            reader.nextLine();
            for(int i = 0; i < totalWeps; i++)
            {
                System.out.println("Enter weapon number " + (i+1) + " for the class:");
                weps.add(reader.nextLine());
            }
            System.out.println("Enter the total amount of health for the class: ");
            int hp = reader.nextInt();
        try {
            bw.write("TEAM_NAME = DarkRP.createJob(\"" + name + "\", {\n"); 
            bw.write("\tcolor = Color(" + color1 + ", " + color2 + "," + color3 + ", 255),\n"); 
            bw.write("\tmodel = {\n");
            bw.write("\t\t\"" + model + "\",\n");
            bw.write("\t },\n");
            bw.write("\tdescription = [[" + desc + "]],\n");
            bw.write("\tweapons = {");
            for(int i = 0; i < weps.size()-1; i++)
            {
                bw.write("\"" + weps.get(i) + "\", ");
            }
            bw.write("\"" + weps.get(weps.size()-1) + "\"},\n");
            bw.write("\tcommand = \"TEAM\",\n");
            bw.write("\tmax = 0,\n");
            bw.write("\tsalary = 100,\n");
            bw.write("\tadmin = 0,\n");
            bw.write("\tvote = false,\n");
            bw.write("\thasLicense = true,\n");
            bw.write("\tcandemote = false,\n");
            bw.write("\tcategory = \"category\",\n");
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
        reader.nextLine();
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
