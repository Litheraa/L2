package ru.aston.khramov_vo.task_1.L6;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Controller {
	private final TXTWorker worker = new TXTWorker();
	private final JFrame frame;

	public Controller() {
		frame = new JFrame("Выберите действие");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setSize(200, 200);
		frame.setResizable(false);
		frame.setLayout(new FlowLayout());

		JButton read = new JButton("Прочитать файл");
		read.addActionListener(e -> {if (showFileText(FileChooser.chooseFile("Какой файл вы хотите прочитать?"))) {
			System.exit(0);}
		});

		JButton write = new JButton("Записать в файл");
		write.addActionListener(e -> {
			if (writeToFile(FileChooser.chooseFile("В какой файл вы хотите добавить строку?"))) {
				System.exit(0);
			}
		});

		JButton merge = new JButton("Совместить файлы в один");
		merge.addActionListener(e -> {
			if (mergeFile(FileChooser.chooseFile("Выберите файл-получатель"))) {
				System.exit(0);
			}
		});

		JButton corrupt = new JButton("Испортить файл");
		corrupt.addActionListener(e -> {
			if (worker.corruptTextInFile(FileChooser.chooseFile("Какой файл вы хотите испорить?"))) {
				System.exit(0);
			}

		});

		frame.add(read);
		frame.add(write);
		frame.add(merge);
		frame.add(corrupt);
		frame.setVisible(true);
	}

	private boolean writeToFile(File file) {
		JTextArea textArea = new JTextArea();
		List<String> list = new ArrayList<>();
		list.add(JOptionPane.showInputDialog(frame, textArea, JOptionPane.DEFAULT_OPTION));
		return worker.writeFile(file, list, true);
	}

	private boolean mergeFile(File file) {
		return worker.mergeFiles(FileChooser.chooseFile("Выберите файл-донор"), file);
	}

	private boolean showFileText(File file) {
		List<String> list = new ArrayList<>(worker.readFile(file));
		return JOptionPane.showOptionDialog(frame,
				list,
				"Вот что я прочитал",
				JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE,
				null, null, null) == 0;
	}
}
