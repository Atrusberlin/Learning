package de.dranke.learning.principles.lsp;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;

public class LspTest {

  @DataProvider
  public Object[][] rectangles() {
    return new Object[][] {
        {new Rectangle(3, 4)},
        {new Square(4)}
    };
  }

  @Test(dataProvider = "rectangles")
  public void violation_lsp_when_calculateArea_after_changing_heigth(Rectangle rec) {
    // given
    double width = rec.getWidth();
    double height = 5;

    // when
    rec.setHeight(height);

    // then
    assertThat(rec.calculateArea()).isEqualTo(width * height);
  }

  @Test
  public void violation_lsp_when_height_is_also_changed() {
    // given
    Rectangle rec = new Square(4);
    double oldHeigth = rec.getHeigth();

    // when
    int newWidth = 6;
    rec.setWidth(newWidth);

    // then
    assertThat(rec.getWidth()).isEqualTo(newWidth);
    assertThat(rec.getHeigth()).isNotEqualTo(oldHeigth);
    assertThat(rec.getHeigth()).isEqualTo(newWidth);
  }
}
