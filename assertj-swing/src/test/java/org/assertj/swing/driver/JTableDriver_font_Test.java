/**
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2012-2015 the original author or authors.
 */
package org.assertj.swing.driver;

import static java.awt.Font.PLAIN;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.swing.data.TableCell.row;
import static org.mockito.Mockito.when;

import java.awt.Font;

import org.junit.Test;

/**
 * Tests for {@link JTableDriver#font(JTable, TableCell)}.
 * 
 * @author Alex Ruiz
 * @author Yvonne Wang
 */
public class JTableDriver_font_Test extends JTableDriver_withMockCellReader_TestCase {
  private Font font;

  @Override
  void onSetUp() {
    font = new Font("SansSerif", PLAIN, 8);
  }

  @Test
  public void should_Return_Cell_Font() {
    when(cellReader.fontAt(table, 0, 0)).thenReturn(font);
    Font result = driver.font(table, row(0).column(0));
    assertThat(result).isSameAs(font);
  }
}
