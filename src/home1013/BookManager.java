package home1013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class BookManager {

	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	ArrayList<Book> BookList=new ArrayList<>();
	ArrayList<BookUser> UserList=new ArrayList<>();
	ArrayList<Book> BookList2=new ArrayList<>();

public void createBook() throws IOException, ParseException {
	System.out.println("등록할 책 제목을 입력해주세요.");
	String bookName=br.readLine();
	System.out.println("등록할 작가이름을 입력해주세요.");
	String authorName=br.readLine();
	System.out.println("등록일을 입력해주세요.");
	String date=br.readLine();
	Date d=new SimpleDateFormat("yyyyMMdd").parse(date);
	Book b=new Book(bookName, authorName, d);
	BookList.add(b);
	
	System.out.println("등록이 완료되었습니다.");
	
}

public void readBook() {
	for(Book b:BookList) {
		System.out.println(b);
	}
}

public void updateBook() throws IOException {
	System.out.println("수정할 책 제목을 입력해주세요.");
	boolean flag=false;
	String name=br.readLine();
	for(Book b:BookList) {
		if(b.getBookName().equals(name)) {
			System.out.println("변경할 책 제목을 입력해주세요.");
			String a=br.readLine();
			b.setBookName(a);
			System.out.println("변경할 작가명을 입력해주세요.");
			String c=br.readLine();
			b.setAuthorName(c);
			flag=true;
		}
	}if(flag==false) {
		System.out.println("책을 찾을 수 없습니다.");
	}
}

public void deleteBook() throws IOException {
	System.out.println("삭제할 책 제목을 입력해주세요.");
	boolean flag=false;
	String name=br.readLine();
	for(int i=0; i<BookList.size(); i++) {
		if(BookList.get(i).getBookName().equals(name)) {
			BookList.remove(i);
			System.out.println("삭제되었습니다.");
			flag=true;
		}
		
	}if(flag==false) {
		System.out.println("책을 찾을 수 없습니다.");
	}
}

public void printBook() {
	System.out.println("---메뉴---");
	System.out.println("1.도서 등록");
	System.out.println("2.도서 목록");
	System.out.println("3.도서 수정");
	System.out.println("4.도서 삭제");
	System.out.println("5.프로그램 종료");
	System.out.println("메뉴를 입력하세요.");
}

public void signUp() throws IOException {
	System.out.println("이름을 입력하세요.");
	String name=br.readLine();
	System.out.println("ID를 입력해주세요.");
	String ID=br.readLine();
	System.out.println("password를 입력해주세요.");
	String password=br.readLine();
	BookUser bu=new BookUser(name, ID, password);
	
	UserList.add(bu);
	System.out.println("회원가입이 완료되었습니다.");
}

public void searchBook() throws IOException {
	int choice=0;
	System.out.println("검색내용을 선택하세요.");
	System.out.println("1.제목 검색");
	System.out.println("2.저자 검색");
	choice=Integer.parseInt(br.readLine());
	
	switch(choice) {
	case 1:	
		System.out.println("검색할 책 제목을 입력해주세요.");
		String name=br.readLine();
		boolean flag=false;
		for(Book b:BookList) {
			if(b.getBookName().equals(name)) {
				System.out.print("제목:"+b.getBookName());
				System.out.println("작가명:"+b.getAuthorName());
			flag=true;
			}
		}if(flag==false) {
			System.out.println("책을 찾을 수 없습니다.");
		}
		break;
	case 2:
		System.out.println("검색할 저자를 입력해주세요.");
		String name2=br.readLine();
		boolean flag2=false;
		for(Book b:BookList) {
			if(b.getAuthorName().equals(name2)) {
				flag2=true;
				System.out.println("제목:"+b.getBookName());
				System.out.println("제목:"+b.getAuthorName());
			}
		}if(flag2==false) {
			System.out.println("저자를 찾을 수 없습니다.");
		}
		break;
	}
}

public void rentalBook() throws IOException {
	boolean userFlag=false;
	boolean bookFlag=false;
	boolean lentFlag=false;
	System.out.println("회원명을 입력해주세요.");
	String a=br.readLine();
	for(BookUser bu:UserList) {
		if(bu.getName().equals(a)) {
			System.out.println("대여할 책 제목을 입력해주세요.");
			String name=br.readLine();
			userFlag=true;
			for(Book b:BookList) {
				if(b.getBookName().equals(name)) {
					bookFlag=true;
					if(b.isRent()==true) {
						lentFlag=true;
					}else {
						bu.insertBook(b);
						b.setRent(true);
					}
				}
			}
		}
	} if(userFlag==false) {
		System.out.println("회원이 아닙니다.");
	}else if(bookFlag==false) {
		System.out.println("책이 없습니다.");
	}else if(lentFlag==true) {
		System.out.println("이미 대출된 책입니다.");
	}
	if(userFlag && bookFlag && !lentFlag) {
		System.out.println("대출 완료");
	}
}

public void returnBook() throws IOException {
	boolean userFlag=false;
	boolean bookFlag=false;
	boolean returnFlag=false;
	System.out.println("회원명을 입력하세요.");
	String a=br.readLine();
	for(BookUser bu:UserList) {
		if(bu.getName().equals(a)) {
			userFlag=true;
			System.out.println("반납할 책 제목을 입력하세요.");
			String name=br.readLine();
			for(Book b:BookList) {
				if(b.getBookName().equals(name)) {
					bookFlag=true;
					if(b.isRent()==true) {
					bu.deleteBook(b);
					b.setRent(false);
					}else {
						returnFlag=true;
					}
				}
			}
		}
	}if(userFlag==false) {
		System.out.println("회원을 찾을 수 없습니다.");
	}else if(bookFlag==false) {
		System.out.println("반납할 책을 찾을 수 없습니다.");
	}else if(returnFlag==true) {
		System.out.println("이미 반납된 책입니다.");
	}
	if(userFlag && bookFlag && !returnFlag) {
		System.out.println("반납완료");
	}
}

public void printUser() {
	System.out.println("---메뉴---");
	System.out.println("1.회원가입");
	System.out.println("2.도서검색");
	System.out.println("3.도서대출");
	System.out.println("4.도서반납");
	System.out.println("5.프로그램종료");
	System.out.println("메뉴를 입력하세요.");
}

public void userMenu() throws NumberFormatException, IOException {
	int menu=-1;
	printUser();
	menu=Integer.parseInt(br.readLine());
	
	switch(menu) {
	case 1: signUp(); break;
	case 2: searchBook(); break;
	case 3: rentalBook(); break;
	case 4: returnBook(); break;
	case 5: break;
	default:
		System.out.println("잘못된 메뉴입니다.");
		break;
	}
}


public void libMenu() throws NumberFormatException, IOException, ParseException {
	int menu=-1;
	printBook();
	menu=Integer.parseInt(br.readLine());
	
	switch(menu) {
	case 1: createBook(); break;
	case 2: readBook(); break;
	case 3: updateBook(); break;
	case 4: deleteBook(); break;
	case 5: break;
	default :
	System.out.println("잘못된 메뉴입니다.");
	break;
	}
	
}
}





