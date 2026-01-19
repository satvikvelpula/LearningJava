import java.util.Scanner;

public class NameGenerator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] first_names = {"Josh", "Michael", "John", "Fred"};
        String[] last_names = {"King", "Reed", "Bond", "Anderson"};

        System.out.println("How many names?: ");
        int num = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= num; i++) {
            String randfirst_name;
            String randlast_name;
            int fn_content = first_names.length;
            int ln_content = last_names.length;

            int randfn_index = (int) (Math.random() * fn_content);
            int randln_index = (int) (Math.random() * ln_content);

            randfirst_name = first_names[randfn_index];
            randlast_name = last_names[randln_index];

            System.out.println(randfirst_name + " " + randlast_name);
        }

    }
}
