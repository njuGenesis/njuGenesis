package presentation.contenui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class GComboBoxRenderer implements ListCellRenderer{

	private DefaultListCellRenderer defaultCellRenderer = new DefaultListCellRenderer();

	public GComboBoxRenderer() {
		super();
	}

	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {

		JLabel renderer = (JLabel)defaultCellRenderer.getListCellRendererComponent(
				list, value, index, isSelected, cellHasFocus);
		if(isSelected){
			renderer.setBackground(Color.BLACK);
			renderer.setForeground(Color.WHITE);
		}else{
			renderer.setBackground(Color.WHITE);
		}
		list.setSelectionBackground(Color.white);
		list.setBorder(null);
//		renderer.setFont(XUtil.defaultComboBoxFont);
		renderer.setHorizontalAlignment(JLabel.CENTER);
		return renderer;
	}

}
