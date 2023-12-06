package menu;


import insert.*;
import objects.*;
import select.*;
import delete.*;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class dir {
    Scanner scanner = new Scanner(System.in);
    Customers customer = new Customers();
    public void loginPage(){
        System.out.println("-------------------------------");
        System.out.println("请输入你的编号和用户名");
        System.out.println("-------------------------------");
        String custID = scanner.next();
        String custName = scanner.next();

        if(Objects.equals(custID, "00000")){
            System.out.println("欢迎您，管理员");
        }
        insertCustomer insertCustomer = new insertCustomer();
        customer.setCustID(custID);
        customer.setCustName(custName);

        if(insertCustomer.login(customer)){
            System.out.println("登录成功～");
            welcomePage();
        }
        else {
            System.out.println("未注册用户，请输入用户编号和用户名");
            custID = scanner.next();
            custName = scanner.next();
            if(insertCustomer.register(custID,custName)){
                customer.setCustID(custID);
                customer.setCustName(custName);
                welcomePage();
            }
        }
    }
    public void welcomePage(){
        while (true){
            System.out.println("-------------------------------");
            System.out.println("------"+customer.getCustName()+",欢迎进入旅程管理系统--------");
            System.out.println("----------请选择功能-------------");
            System.out.println("1，旅程预约");
            System.out.println("2，查询预约");
            System.out.println("3，取消预约");
            System.out.println("4，查询航行线路");
            System.out.println("5，退出系统");
            System.out.println("-------------------------------");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    makeReservation();
                    break;
                case 2:
                    queryReservation();
                    break;
                case 3:
                    deleteReservation();
                    break;
                case 4:
                    queryLine();
                    break;
                case 5:
                    System.out.println("感谢使用本系统～");
                    System.exit(0);
                default:
                    System.out.println("输入非法，请重新输入～");
            }
        }
    }
    public void makeReservation(){
        while (true){
            System.out.println("-------------------------------");
            System.out.println("-----------旅程预约菜单--------");
            System.out.println("----------请选择功能-------------");
            System.out.println("1，航班预约");
            System.out.println("2，酒店预约");
            System.out.println("3，大巴预约");
            System.out.println("4，返回上一级菜单");
            System.out.println("-------------------------------");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("请输入航班的出发城市和目的地城市：");
                    List<Flights> list = new selectFlights().chooseFlight(scanner.next(),scanner.next());
                    if (list.size() == 0){
                        System.out.println("对不起，暂时没有您需要的航班～");
                    }
                    else {
                        System.out.println(list);
                        System.out.println("请输入您想要预定的航班号：");
                        new insertReservation().reserve(choice,scanner.next(),customer);
                    }
                    break;
                case 2:
                    System.out.println("请输入预定的城市和预期价位：");
                    List<Hotels> listHotel = new selectHotels().chooseHotel(scanner.next(),scanner.nextInt());
                    if (listHotel.size() == 0){
                        System.out.println("对不起，暂时没有您需要的酒店～");
                    }
                    else {
                        System.out.println(listHotel);
                        System.out.println("请输入您想要预定的酒店号：");
                        new insertReservation().reserve(choice,scanner.next(),customer);
                    }
                    break;
                case 3:
                    System.out.println("请输入预定的城市和预期价位：");
                    List<Bus> listBus = new selectBus().chooseBus(scanner.next(),scanner.nextInt());
                    if (listBus.size() == 0){
                        System.out.println("对不起，暂时没有您需要的大巴～");
                    }
                    else {
                        System.out.println(listBus);
                        System.out.println("请输入您想要预定的大巴号：");
                        new insertReservation().reserve(choice,scanner.next(),customer);
                    }
                    break;
                case 4:
                    return;
                default:
                    System.out.println("输入非法，请重新输入～");

            }
        }

    }
    public void queryReservation(){
        while (true){
            System.out.println("-------------------------------");
            System.out.println("-----------查询预约菜单--------");
            System.out.println("----------请选择功能-------------");
            System.out.println("1，查看航班预约");
            System.out.println("2，查看酒店预约");
            System.out.println("3，查看大巴预约");
            System.out.println("4，返回上一级菜单");
            System.out.println("-------------------------------");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                case 2:
                case 3:
                    List<Reservations> list = new selectReservation().findCustomer(customer,choice);
                    System.out.println(list);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("输入非法，请重新输入～");
            }
        }
    }
    public void deleteReservation(){
        while (true){
            System.out.println("-------------------------------");
            System.out.println("-----------取消预约菜单--------");
            System.out.println("----------请选择功能-------------");
            System.out.println("1，取消航班预约");
            System.out.println("2，取消酒店预约");
            System.out.println("3，取消大巴预约");
            System.out.println("4，返回上一级菜单");
            System.out.println("-------------------------------");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                case 2:
                case 3:
                    List<Reservations> list = new selectReservation().findCustomer(customer,choice);
                    System.out.println(list);
                    System.out.println("请输入要删除的编号：");
                    new deleteReservation().delete(choice,scanner.next(),customer);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("输入非法，请重新输入～");
            }
        }
    }
    public void queryLine(){
        selectReservation selectReservation = new selectReservation();
        selectReservation.findFlight(customer);
        selectReservation.findHotel(customer);
        selectReservation.findBus(customer);
    }
}
