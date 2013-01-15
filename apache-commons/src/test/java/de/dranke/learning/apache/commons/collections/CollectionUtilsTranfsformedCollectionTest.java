package de.dranke.learning.apache.commons.collections;

import de.dranke.learning.trainingmodel.Book;
import de.dranke.learning.trainingmodel.Creator;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import static org.fest.assertions.Assertions.assertThat;

public class CollectionUtilsTranfsformedCollectionTest {

  private Collection<Book> books;

  @BeforeMethod
  public void setUp() throws Exception {
    books = new ArrayList<>();
    books.add(createBook("TitleOne"));
    books.add(createBook("TitleTwo", new Creator("Myers, Mike", "Comment")));
    books.add(createBook("TitleThree",
        new Creator("Myers, Mike", "Comment"),
        new Creator("Moore, Roger", "Agent")));

  }

  private Book createBook(String title, Creator... creators) {
    Book book = new Book(title);
    book.addCreator(creators);
    return book;
  }

  @Test
  public void transformedCollection_transforms_new_added_elements() {
    // given
    Transformer bookTransformer = new Transformer() {
      @Override
      public Object transform(Object o) {
        Book book = (Book) o;
        return book.getTitle();
      }
    };
    ArrayList originCollection = new ArrayList();
    originCollection.add(new Book("TitleOne"));

    // when
    Collection transformerList = CollectionUtils.transformedCollection(originCollection, bookTransformer);
    transformerList.add(new Book("TitleFour"));

    // then
    assertThat(transformerList).hasSize(2);
    Iterator iterator = transformerList.iterator();
    assertThat(iterator.next()).isInstanceOf(Book.class);
    assertThat(iterator.next()).isInstanceOf(String.class);
  }
}
