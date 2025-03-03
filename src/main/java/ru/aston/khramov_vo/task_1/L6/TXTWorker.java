package ru.aston.khramov_vo.task_1.L6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class TXTWorker {
	private static final Logger logger = LoggerFactory.getLogger(TXTWorker.class);

	public List<String> readFile(File file) {
		List<String> list = new ArrayList<>();
		try (BufferedReader fileReader = Files.newBufferedReader(file.toPath())) {
			list = fileReader.lines().toList();
		} catch (IOException | UncheckedIOException e) {
			logger.error("{} can't read file {}", e, file);
		}
		return list;
	}

	public boolean writeFile(File file, List<String> strings, boolean append) {
		try(FileWriter fileWriter = new FileWriter(file, append)) {
			for (String s : strings) fileWriter.append(s).append(System.lineSeparator());;
		} catch (IOException | UncheckedIOException e) {
			logger.error("{}can't write to file{}", e, file);
			return false;
		}
		return true;
	}

	public boolean mergeFiles(File fromFile, File toFile) {
		return writeFile(toFile, readFile(fromFile), true);
	}

	public boolean corruptTextInFile(File file) {
		List<String> list = new ArrayList<>(readFile(file));
		list.replaceAll(s -> s.replaceAll("[^a-zA-Zа-яА-Я0-9]", "\\$"));

//		try (FileWriter fileWriter = new FileWriter(file)) {
//			for (String s : list) {
//				fileWriter.append(s).append(System.lineSeparator());
//			}
//		} catch (IOException | UncheckedIOException e) {
//			logger.error("{} can't write to file {}", e, file);
//			return false;
//		}
//		return true;
		return writeFile(file, list, false);
	}
}
