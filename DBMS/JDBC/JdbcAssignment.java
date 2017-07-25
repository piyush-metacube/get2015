package jdbcassignment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcAssignment {
    public static void main(String[] args) {
	System.out.println(getAllBooksTitle("Ramesh"));
	System.out.println(issueBookToMember("Alchemist", "Suresh"));
	System.out.println(deleteUnIssuedBooks());
    }

    /*
     * Fetch all the books published by author, given the name of the author.
     * 
     * Return the books data (List of Titles).
     */
    private static List<Title> getAllBooksTitle(String authorName) {
	List<Title> bookTitleList = new ArrayList<Title>();

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	ConnectionUtil conUtil = new ConnectionUtil();
	con = conUtil.getConnection();
	String query = "select title_name from title where title_id in (select title_id from title_author where author_id=(select author_id from author where author_name=?))";

	try {
	    ps = con.prepareStatement(query);

	    ps.setString(1, authorName);

	    rs = ps.executeQuery();

	    while (rs.next()) {
		bookTitleList.add(new Title(rs.getString(1)));
	    }

	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    /* close connection */
	    try {
		if (con != null) {
		    con.close();
		}
		if (ps != null) {
		    ps.close();
		}
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
	return bookTitleList;
    }

    /*
     * Given the name of the book, to be issued by an existing member.
     * 
     * Return flag to indicate whether the the book has been issued or not.
     */
    private static boolean issueBookToMember(String bookName, String memberName) {
	Connection con = null;
	PreparedStatement ps = null;
	int queryResponse = -1;
	ConnectionUtil conUtil = new ConnectionUtil();
	con = conUtil.getConnection();
	String query = "INSERT INTO Boo_Issue(issue_date,accession_No, member_id, due_Date) VALUES(now(),(select accession_no from books where status=1 and title_id =( select title_id from title where title_name= ?) limit 0,1), (select member_id from members where member_name = ?),'2015-11-06')";

	try {
	    ps = con.prepareStatement(query);
	    ps.setString(1, bookName);
	    ps.setString(2, memberName);

	    queryResponse = ps.executeUpdate();

	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    /* close connection */
	    try {
		if (con != null) {
		    con.close();
		}
		if (ps != null) {
		    ps.close();
		}

	    } catch (SQLException e) {
		e.printStackTrace();
	    }

	}
	if (queryResponse > 0)
	    return true;
	else
	    return false;
    }

    /*
     * Delete all those books which were not issued in last 1 year.
     * 
     * Return the number of books deleted.
     */
    private static int deleteUnIssuedBooks() {
	Connection con = null;
	PreparedStatement ps = null;
	int queryResponse = -1;
	ConnectionUtil conUtil = new ConnectionUtil();
	con = conUtil.getConnection();
	String query = "DELETE FROM books WHERE accession_no = (SELECT accession_no FROM book_issue WHERE (DATEDIFF(NOW(),ISSUE_DATE))>365) OR (accession_No NOT IN(select accession_No FROM Book_issue) AND DATEDIFF(NOW(), purchase_Date) > 365)";

	try {
	    ps = con.prepareStatement(query);
	    queryResponse = ps.executeUpdate();

	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    /* close connection */
	    try {
		if (con != null) {
		    con.close();
		}
		if (ps != null) {
		    ps.close();
		}

	    } catch (SQLException e) {
		e.printStackTrace();
	    }

	}
	return queryResponse;
    }
}
