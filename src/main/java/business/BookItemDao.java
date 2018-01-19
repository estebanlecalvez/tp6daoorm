package business;

import java.util.List;

public class BookItemDao {
	
	private static List bookItems;

	/**
	 * Create new book in dummy database. Updates the id and insert new
	 * book in list.
	 * 
	 * @param book
	 *            Book object
	 * @return book object with updated id
	 */
	public BookItem create(BookItem bookItem) {
		bookItem.id=(int) System.currentTimeMillis();
		bookItems.add(bookItem);
		return bookItem;
	}
}
