package home1013;

import java.util.Date;

/*도서관 도서 대출 프로그램

1단계 기능
: 도서관 책 관리 화면(CRUD)

-BookManager클래스 추가
1. 멤버변수
bufferedReader
BookList

2. 핵심 메소드
1) 도서 등록 
2) 도서 목록
3) 도서 수정
4) 도서 삭제

Book 클래스
도서명, 작가명, 등록일
get/set */

/*2단계 기능
: 사용자 책 대출 화면 추가(프로그램 시작 시 도서관 책 관리 화면과 도서관 이용 화면 중 선택)

-Book 클래스 수정
멤버 변수 '대출 상태' 추가

- User 클래스 추가
이름, 도서 대출 목록, 도서 대출 내역 

- BookManager 클래스 수정
1. 멤버변수 userList 추가 
2. 메소드
1) 회원 가입
2) 도서 검색
3) 도서 대출
3) 도서 반납 */

public class Book {

	private String bookName;
	private String authorName;
	private Date regDate;
	private String condition;
	private boolean rent = false;
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public boolean isRent() {
		return rent;
	}
	public void setRent(boolean rent) {
		this.rent = rent;
	}
	public Book(String bookName, String authorName, Date regDate) {
		super();
		this.bookName = bookName;
		this.authorName = authorName;
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "제목: " + bookName + ", 작가명:" + authorName + ", 등록일:" + regDate;
	}
	
	
	
	
	
	
	
	
}
