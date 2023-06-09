package test;

import java.io.*;
import java.util.Calendar;
import java.util.Objects;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) throws Exception {
        while(true) {
            System.out.println("1. 등록\t2. 목록\t3. 상세\t4. 삭제\t5. 종료");
            System.out.print("번호선택>> ");
            Scanner scn = new Scanner(System.in);
            int step = 0;
            try {
                step = scn.nextInt();
            } catch (Exception e) {
                System.out.println("숫자를 입력해주세요.");
            }
            if(step == 1) {
                System.out.println("[ 회원등록 ]");
                System.out.print("* 아이디 >> ");
                String id = scn.next();
                System.out.print("* 생년월일 >> ");
                String birthday = scn.next();
                System.out.print("* 핸드폰 >> ");
                String phone = scn.next();
                if (intoInfo(id, birthday, phone)) {
                    System.out.println("등록이 완료되었습니다.");
                }
            }
            else if(step == 2) {
                System.out.println("------------------");
                System.out.println("[ 회원목록 ]");
                System.out.println("------------------");
                System.out.println("아이디\t출생년도(나이)\t핸드폰");

                String users = getUser();
                if(users.isBlank()) {
                    System.out.println("등룍된 회원이 없습니다.");
                    continue;
                }
                String[] user = users.split("\n");
                for (String s : user) {
                    String[] info = s.split("/");

                    int year = Integer.parseInt(info[1].substring(0, 4));
                    Calendar calendar = Calendar.getInstance();
                    int currentYear = calendar.get(Calendar.YEAR);
                    int age = (currentYear - year + 1);
                    System.out.println(info[0] + "\t\t" + year + "(" + age + ")\t\t" + info[2]);
                }
            }
            else if(step == 3) {
                System.out.println("[상세정보]");
                System.out.print("아이디 >> ");
                String id = scn.next();
                userInfo(id);
            }
            else if(step == 4) {
                System.out.println("[상세정보]");
                System.out.print("아이디 >> ");
                String id = scn.next();
                deleteUser(id);
            }
            else if(step == 5) {
                System.out.println("종료합니다.");
                break;
            }
        }
    }

    public static boolean intoInfo(String id, String birthday, String phone) throws Exception {
        if(!birthday.matches("[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}")) {
            System.out.println("생일형식이 올바르지 않습니다.");
            return false;
        }
        else if(!phone.matches("^01(0|1|[6-9])-[0-9]{3,4}-[0-9]{4}")) {
            System.out.println("전화번호 형식이 올바르지 않습니다.");
            return false;
        }
        String users = getUser();
        if(Objects.equals(users.split("/")[0], id)) {
            System.out.println("중복된 아이디가 존재합니다.");
            return false;
        }
        String info = users + id + "/" + birthday + "/" + phone + "\n";
        return saveUser(info);
    }

    public static void userInfo(String id) throws Exception {
        String users = getUser();
        if(!users.contains(id)) {
            System.out.println("미등록 아이디입니다.");
            return;
        }
        String[] user = users.split("\n");
        for(String s : user) {
            String[] info = s.split("/");
            if(s.equals(info[0])) {
                System.out.println("아이디 : " + info[0]);
                System.out.println("출생일 : " + info[1]);
                System.out.println("핸드폰 : " + info[2]);
                break;
            }
        }
    }

    public static void deleteUser(String id) throws Exception {
        String users = getUser();
        if(!users.contains(id)) {
            System.out.println("미등록 아이디입니다.");
            return;
        }
        String[] user = users.split("\n");
        String split = "";
        for(String s : user) {
            if(s.split("/")[0].equals(id)) {
                split = s + "\n";
                break;
            }
        }
        String[] split1 = users.split(split);
        if (split1.length == 1) users = split1[0];
        else users = split1[0] + split1[1];

        if(saveUser(users)) System.out.println("삭제되었습니다.");
        else System.out.println("삭제에 실패했습니다.");
    }

    public static String getUser() throws Exception {
        File file = new File("C:/java_io_test/userInfo.txt");
        if(!file.exists()) return "";

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        StringBuilder str = new StringBuilder();
        String line = "";
        while( ( line = br.readLine() ) != null ) {
            str.append(line).append("\n");
        }
        br.close();
        return str.toString();
    }

    public static boolean saveUser(String info) {
        try {
            File file = new File("C:/java_io_test/userInfo.txt");

            FileWriter fw = new FileWriter(file, false);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(info);
            bw.close();
        } catch (Exception e) {
            System.out.println("저장에 실패했습니다.");
            return false;
        }
        return true;
    }
}
