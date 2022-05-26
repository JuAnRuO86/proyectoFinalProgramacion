package componentes.visuales;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BotonAzul extends BotonRojo {
	public BotonAzul(String s) {
		super(s);
		estilosDefault();
		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				setForeground(new Color(100, 100, 200));
				setBackground(new Color(0, 0, 50));
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				estilosDefault();
			}
		});
	}

	private void estilosDefault() {
		this.setForeground(new Color(0, 0, 153));
		this.setBackground(new Color(102, 100, 200));
	}

}
