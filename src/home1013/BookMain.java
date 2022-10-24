package home1013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

public class BookMain {

	public static void main(String[] args) throws IOException, ParseException {
		int menu=-1;
		BookManager bm=new BookManager();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		do {
			System.out.println("메뉴를 선택해주세요.");
	        System.out.println("==============");
	        System.out.println("1. 도서 관리");
	        System.out.println("2. 도서관 이용");
	        System.out.println("3. 프로그램 종료");
	        System.out.println("==============");
	        menu=Integer.parseInt(br.readLine());
        	    switch(menu) {
			        case 1: bm.libMenu(); break;
			        case 2: bm.userMenu(); break;
			        case 3: break;
			        default: 
			        	System.out.println("잘못된 메뉴입니다.");
			        	break;
		        }
		}while(menu!=3);
		System.out.println("프로그램 종료");
	}
		
}
