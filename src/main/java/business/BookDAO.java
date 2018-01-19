package business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class BookDAO {


	private static List books;
	
	
	
	/**
	 * Create new book in dummy database. Updates the id and insert new
	 * book in list.
	 * 
	 * @param book
	 *            Book object
	 * @return book object with updated id
	 */
	public Book create(Book book) {
		book.id=(int) System.currentTimeMillis();
		books.add(book);
		return book;
	}

//	/**
//	 * Delete the customer object from dummy database. If customer not found for
//	 * given id, returns null.
//	 * 
//	 * @param id
//	 *            the customer id
//	 * @return id of deleted customer object
//	 */
//	public Long delete(Long id) {
//
//		for (Book c : books) {
//			if (c.id.equals(id)) {
//				books.remove(c);
//				return id;
//			}
//		}
//
//		return null;
//	}
//
//	/**
//	 * Update the customer object for given id in dummy database. If customer
//	 * not exists, returns null
//	 * 
//	 * @param id
//	 * @param customer
//	 * @return customer object with id
//	 */
//	public Book update(Long id, Book book) {
//
//		for (Book c : book) {
//			if (c.id.equals(id)) {
//				book.id=c.id;
//				books.remove(c);
//				books.add(book);
//				return book;
//			}
//		}
//
//		return null;
//	}

}

