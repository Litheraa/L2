package task_1;

import L3.entities.Time;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.aston.khramov_vo.task_1.City;
import ru.aston.khramov_vo.task_1.StreamHW;
import ru.aston.khramov_vo.task_1.User;

import java.io.File;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class StreamHWTest {
	StreamHW streamHW = new StreamHW();
	List<Integer> inputList = new ArrayList<>();

	@BeforeEach
	public void create() {
		for (int i = 0; i < 100; i++) {
			inputList.add(i);
		}
	}


	@DisplayName("Вывести все четные числа в диапазоне от 1 до 100")
	@Test
	public void allEvenFrom0To100() {
		int[] arrExpected = new int[50];
		for (int i = 1, j = 0; i <= 100; i++) {
			if (i % 2 != 0) continue;
			arrExpected[j++] = i;
		}
		int[] arrActual = streamHW.allEvenFrom1To100();
		assertArrayEquals(arrActual, arrExpected);
	}

	@DisplayName("Умножить каждое число в массиве [1, 2, 3, 4, 5] на 2")
	@Test
	public void eachIntMultipleBy2() {
		int[] arrExpected = new int[5];
		for (int i = 1; i <= 5; i++) {
			arrExpected[i - 1] = i * 2;
		}
		int[] arrActual = streamHW.eachIntMultipleBy2(new int[]{1, 2, 3, 4, 5});
		assertArrayEquals(arrActual, arrExpected);
	}

	@DisplayName("Посчитать сумму чисел в массиве [1, 2, 3, 4, 5], используя reduce()")
	@Test
	public void sumOfArray() {
		int expected = 1 + 2 + 3 + 4 + 5;
		int actual = streamHW.sumOfIntArray(new int[]{1, 2, 3, 4, 5});
		assertSame(expected, actual);
	}

	@DisplayName("Вывести числа в диапазоне от 1 до 50 с шагом 2")
	@Test
	public void arrFrom1To50Step2() {
		int[] arrExpected = new int[25];
		for (int i = 1, j = 0; i <= 50; i++) {
			if (i % 2 == 0) continue;
			arrExpected[j++] = i;
		}
		int[] arrActual = streamHW.allFrom1To50Step2();
		assertArrayEquals(arrExpected, arrActual);
	}

	@DisplayName("Найти первый четный элемент в списке [1, 2, 3, 4, 5]")
	@Test
	public void firstEven() {
		int actual = streamHW.findFirstEven(new int[]{1, 2, 3, 4, 5});
		assertSame(2, actual);
	}

	@DisplayName("Отсортировать элементы массива [1, 3, 5, 7, 9] по возрастанию")
	@Test
	public void ascendingArray() {
		int[] actualArr = streamHW.sortAscending(new int[]{7, 5, 1, 3, 9});
		assertArrayEquals(new int[]{1, 3, 5, 7, 9}, actualArr);
	}

	@DisplayName("Вывести первые 10 чисел в списке [0, 1, 2, … 99]")
	@Test
	public void first10FromList() {
		List<Integer> expectedList = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		List<Integer> actualList = streamHW.first10FromList(inputList);
		assertTrue(actualList.containsAll(expectedList));
	}

	@DisplayName("Пропустить первые 10 элементов списка [0, 1, 2,.., 99] и начать выводить с 11-го элемента, выводя каждый 10-й элемент")
	@Test
	public void listAfter10thElement() {
		List<Integer> expectedList = List.of(10, 20, 30, 40, 50, 60, 70, 80, 90);
		List<Integer> actualList = streamHW.listAfter10Elements(inputList);
		assertTrue(actualList.containsAll(expectedList));
	}

	@DisplayName("Выведите на экран все числа в диапазоне от 1 до 100, которые делятся на 3")
	@Test
	public void dividedBy3() {
		int[] expectedArr = new int[33];
		for (int i = 1, j = 0; i < 100; i++) {
			if (i % 3 != 0) continue;
			expectedArr[j++] = i;
		}
		int[] actualArr = streamHW.allDividedBy3();
		assertArrayEquals(expectedArr, actualArr);
	}

	@DisplayName("Выведите все нечетные числа в заданном массиве")
	@Test
	public void allOdd() {
		int[] expectedArr = new int[50];
		for (int i = 0, j = 0; i < 100; i++) {
			if (i % 2 != 1) continue;
			expectedArr[j++] = i;
		}
		int[] inputArr = IntStream.range(0, 100).toArray();
		int[] actualArr = streamHW.allOdd(inputArr);
		assertArrayEquals(expectedArr, actualArr);
	}

	@DisplayName("Выведите на экран только те элементы списка, которые больше заданного числа")
	@Test
	public void allGreaterThan() {
		int[] expectedArr = new int[9];
		for (int i = 0, j = 0; i < 50; i++) {
			if (i <= 40) continue;
			expectedArr[j++] = i;
		}
		int[] inputArr = IntStream.range(0, 50).toArray();
		int[] actualArr = streamHW.allGreaterThan(inputArr, 40);
		assertArrayEquals(expectedArr, actualArr);
	}

	@DisplayName("Отфильтруйте все элементы списка, которые меньше 0")
	@Test
	public void allGreaterThan0() {
		List<Integer> expectedList = List.of(1, 2, 3, 4, 5);
		List<Integer> inputList = List.of(-1, -5, -7, 0, 1, 2, 3, 4, 5);
		List<Integer> actualList = streamHW.allGreaterThan0(inputList);
		assertTrue(actualList.containsAll(expectedList));
	}

	@DisplayName("Выведите на экран строки, которые начинаются с заданной подстроки")
	@Test
	public void startWith() {
		List<String> expectedList = List.of("Я поел", "Я ушел");
		List<String> inputList = List.of("Я поел", "Я ушел", "Ямщик", "Онидоран", "Кто-то другой");
		List<String> actualList = streamHW.allStartsFrom(inputList, "Я ");
		assertTrue(actualList.containsAll(expectedList));
	}

	@DisplayName("Отфильтруйте объекты по определенному свойству, например, выведите все записи из базы данных, у которых значение поля равно 1")
	@Test
	public void findById() {
		List<Time> actualList = streamHW.findAllById(3L);
		assertTrue(actualList.stream().allMatch(time -> time.getId().equals(3L)));
	}

	@DisplayName("Выведите только те элементы коллекции, которые удовлетворяют определенному условию, например, являются уникальными или имеют определенный формат")
	@Test
	public void findAllMatches() {
		List<String> inputList = List.of("2022", "2019-15-12", "2025-02-07", "Вася");
		List<String> expectedList = List.of("2019-15-12", "2025-02-07");
		List<String> actualList = streamHW.findAllMatches(inputList, "^[0-9]{4}-[0-9]{2}-[0-9]{2}$");
		assertTrue(actualList.containsAll(expectedList));
	}

	@DisplayName("Отфильтруйте элементы массива, которые не являются числами")
	@Test
	public void filterAllNonNumber() {
		Time time = new Time(LocalDate.now());
		Object[] inputArr = {"Строка", "1", 12, BigDecimal.valueOf(117 / 4), time};
		Object[] expectedArr = {"Строка", "1", time};
		Object[] actualArr = streamHW.filterAllNumber(inputArr);
		assertArrayEquals(expectedArr, actualArr);
	}

	@DisplayName("Выведите на экран элементы списка, которые не входят в другой список")
	@Test
	public void dropAllFrom() {
		List<String> inputListFull = new ArrayList<>();
		inputListFull.add("Вася");
		inputListFull.add("Ваня");
		inputListFull.add("Женя");
		inputListFull.add("Петя");
		inputListFull.add("Катя");
		inputListFull.add("Галя");
		List<String> inputToDrop = List.of("Женя", "Петя", "Галя");
		List<String> expectedList = List.of("Вася", "Ваня", "Катя");
		List<String> actualList = streamHW.findAllExcept(inputListFull, inputToDrop);
		assertTrue(expectedList.containsAll(actualList));
	}

	@DisplayName("Проверить, все ли числа в массиве [0, 1, …, 19] являются четными")
	@Test
	public void allEven() {
		int[] inputArr = IntStream.range(0, 20).toArray();
		boolean actualBool = streamHW.isAllEven(inputArr);
		assertFalse(actualBool);
	}

	@DisplayName("Проверить, есть ли четное число в списке [0, 1, 2, 3]")
	@Test
	public void anyEven() {
		boolean actualBool = streamHW.isAnyEven(new int[]{0, 1, 2, 3});
		assertTrue(actualBool);
	}

	@DisplayName("Собрать все уникальные элементы Stream в список и отсортировать их")
	@Test
	public void allUniqueAndSorted() {
		List<String> inputList = new ArrayList<>();
		inputList.add("Сема");
		inputList.add("Петя");
		inputList.add("Артем");
		inputList.add("Саша");
		inputList.add("Сема");
		inputList.add("Петя");
		List<String> expectedList = List.of("Артем", "Петя", "Саша", "Сема");
		List<String> actualList = streamHW.uniqueAndSorted(inputList);
		assertTrue(CollectionUtils.isEqualCollection(actualList, expectedList));
	}

	@DisplayName("Собрать элементы Stream в карту, где ключом будет первая буква каждого слова, а значением — само слово. Отсортировать ключи в алфавитном порядке")
	@Test
	public void mapByFirstLetters() {
		Stream<String> s = Stream.of("Значение", "Большое значение", "Огромное значение");
		Map<String, String> expectedMap = Map.of("З", "Значение", "Б", "Большое значение", "О", "Огромное значение");
		Map<String, String> actualMap = streamHW.streamToMap(s);
		assertEquals(expectedMap, actualMap);
	}

	@DisplayName("Собрать даты в Stream в список, где каждый элемент — это количество дат в каждом месяце года")
	@Test
	public void monthCounting() {
		Stream<LocalDate> inputDates = Stream.of(
				LocalDate.now(),
				LocalDate.of(2025, 2, 2),
				LocalDate.of(2024, 3, 7),
				LocalDate.of(2012, 12, 12));
		Map<Month, Long> expectedMap = Map.of(Month.MARCH, 2L, Month.FEBRUARY, 1L, Month.DECEMBER, 1L);
		Map<Month, Long> actualMap = streamHW.monthsInStream(inputDates);
		assertEquals(expectedMap, actualMap);
	}

	@DisplayName("Собрать файлы в Stream в список, где каждый элемент — количество файлов с определенным расширением")
	@Test
	public void getFileExtensionsCount() {
		Stream<Path> inputPaths = Stream.of(
				new File("файл.txt").toPath(),
				new File("блокнот.txt").toPath(),
				new File("рисунок.jpg").toPath(),
				new File("рисунок.png").toPath(),
				new File("запись.mp3").toPath());
		Map<String, Long> expectedMap = Map.of("txt", 2L, "jpg", 1L, "png", 1L, "mp3", 1L);
		Map<String, Long> actualMap = streamHW.extensionCounting(inputPaths);
		assertEquals(expectedMap, actualMap);
	}

	@DisplayName("Собрать пользователей в Stream в список объектов, где каждый объект содержит информацию о городе проживания пользователя и количестве пользователей из этого города")
	@Test
	public void cityList() {
		Stream<User> inputUsers = Stream.of(
				new User("Вася", "Грозный"),
				new User("Петя", "Грозный"),
				new User("Миша", "Москва"),
				new User("Ира", "Питер"),
				new User("Леша", "Великие васюки"),
				new User("Вася", "Смоленск"));
		List<City> expectedList = List.of(
				new City("Грозный", 2L),
				new City("Москва", 1L),
				new City("Питер", 1L),
				new City("Великие васюки", 1L),
				new City("Смоленск", 1L));
		List<City> actualList = streamHW.usersToCity(inputUsers);
		assertTrue(expectedList.containsAll(actualList));
	}

	@DisplayName("Создайте Stream из массива чисел, выведите на экран числа, кратные 3 и 5 одновременно")
	@Test
	public void evenTo3And5() {
		int[] expectedArr = {15, 30};
		int[] actualArr = streamHW.intsEvenTo3And5(new int[]{3, 5, 7, 15, 25, 30, 28});
		assertArrayEquals(expectedArr, actualArr);
	}

	@DisplayName("Создайте два Stream-а: один из массива чисел 1…5, второй из массива 5…10. Объедините эти два Stream-а в один и выведите на экран")
	@Test
	public void mergingStreams() {
		Stream<Integer> stream1 = IntStream.range(1, 5).boxed();
		Stream<Integer> stream2 = IntStream.range(5, 10).boxed();
		List<Integer> expectedList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<Integer> actualList = streamHW.mergeStreams(stream1, stream2);
		assertTrue(expectedList.containsAll(actualList));
	}

	@DisplayName("Создайте Stream-у чисел от 1 до 20. Создайте новый Stream, который будет выводить на экран только четные числа и числа, кратные 3. Затем объедините эти два Stream-a в один и выведите результирующий Stream")
	@Test
	public void mergeStreamPrinted() {
		streamHW.mergeStreamsPrinted();
	}

	@DisplayName("Создайте Stream чисел от 2 до 10. Умножьте их на 2 и выведите результат на экран, ограничьтесь первыми десятью результатами")
	@Test
	public void multiply() {
		Stream<Integer> inputStream = IntStream.range(2, 10).boxed();
		List<Integer> expectedList = List.of(4, 6, 8, 10, 12, 14, 16, 18, 20);
		List<Integer> actualList = streamHW.multiplyBy2(inputStream).toList();
		assertTrue(expectedList.containsAll(actualList));
	}

	@DisplayName("Создайте три Stream-а из массивов чисел 1…10, 5…20 и 10…30 соответственно. Объедините их в один Stream и выведите числа, которые кратны 3 или 5")
	@Test
	public void evenTo3Or5() {
		Stream<Integer> inputStream1 = IntStream.range(1, 10).boxed();
		Stream<Integer> inputStream2 = IntStream.range(5, 20).boxed();
		Stream<Integer> inputStream3 = IntStream.range(10, 30).boxed();
		List<Integer> expectedList = List.of(3, 5, 6, 9, 10, 5, 6, 9, 10, 12, 15, 18, 20, 10, 12, 15, 18, 20, 21, 24, 25, 27, 30);
		List<Integer> actualList = streamHW.evenTo3Or5(inputStream1, inputStream2, inputStream3);
		assertTrue(expectedList.containsAll(actualList));
	}

	@DisplayName("Создать стрим из массива чисел и вывести на экран только числа, которые больше 10 и меньше 20")
	@Test
	public void between10and20() {
		Stream<Integer> inputStream = IntStream.range(-10, 100).boxed();
		List<Integer> expectedList = List.of(11, 12, 13, 14, 15, 16, 17, 18, 19);
		List<Integer> actualList = streamHW.allBetween10And20(inputStream).toList();
		assertTrue(expectedList.containsAll(actualList));
	}

	@DisplayName("Создать два стрима: один из чисел от 0 до 10, другой из чисел от 10 до 20. Объединить их в один стрим и вывести на экран числа больше 10")
	@Test
	public void greaterThan10() {
		Stream<Integer> inputStream1 = IntStream.range(0, 10).boxed();
		Stream<Integer> inputStream2 = IntStream.range(10, 20).boxed();
		List<Integer> expectedList = List.of(11, 12, 13, 14, 15, 16, 17, 18, 19);
		List<Integer> actualList = streamHW.allGreaterThan10(inputStream1, inputStream2).toList();
		assertTrue(expectedList.containsAll(actualList));
	}

	@DisplayName("Создать стрим, который выводит числа от 1 до 10. Найти среднее арифметическое этих чисел и вывести его на экран")
	@Test
	public void average() {
		Stream<Integer> inputStream = IntStream.range(1, 10).boxed();
		double expectedValue = 5.0;
		double actualValue = streamHW.arithmeticMean(inputStream);
		assertEquals(expectedValue, actualValue);
	}

	@DisplayName("Создать стрим четных чисел от 2 до 40 и вывести на экран количество элементов в этом стриме")
	@Test
	public void streamCount() {
		Stream<Integer> inputStream = IntStream.range(2, 40).boxed();
		long expectedValue = 38L;
		long actualValue = streamHW.elementsInStream(inputStream);
		assertEquals(expectedValue, actualValue);
	}

	@DisplayName("Разделить элементы Stream на две группы: четные и нечетные, вывести результаты")
	@Test
	public void evenAndOdd() {
		Stream<Integer> inputStream = IntStream.range(0, 100).boxed();
		streamHW.evenAndOdd(inputStream);
	}

	@DisplayName("Разделить слова в Stream на две группы по первой букве: гласные и согласные, посчитать количество слов в каждой группе")
	@Test
	public void vowelsAndConsonants() {
		Stream<String> inputStream = Stream.of(
				"за",
				"новое слово",
				"арбуз",
				"янки",
				"омега");
		streamHW.vowelsAndConsonants(inputStream);
	}

	@DisplayName("Разделить числа в Stream на три группы по остатку от деления на 3 (0, 1, 2), посчитать сумму чисел в каждой группе")
	@Test
	public void divisionBy3() {
		Stream<Integer> inputStream = IntStream.range(0, 10).boxed();
		streamHW.divisionBy3(inputStream);
	}

	@DisplayName("Создание двух Stream из массивов целых чисел и объединение их в один, затем вывод на экран суммы квадратов элементов этого Stream")
	@Test
	public void sumSquare() {
		Stream<Integer> stream1 = IntStream.range(1, 3).boxed();
		Stream<Integer> stream2 = IntStream.range(3, 6).boxed();
		streamHW.square(stream1, stream2);
	}

	@DisplayName("Создание Stream целых чисел и поиск всех чисел, у которых сумма цифр равна заданному числу")
	@Test
	public void sumOfInteger() {
		Stream<Integer> inputStream = IntStream.range(0, 100).boxed();
		List<Integer> expectedList = List.of(5, 14, 23, 32, 41, 50);
		Object[] actualList = streamHW.findByNumerals(inputStream, 5);
		assertTrue(Arrays.stream(actualList).toList().containsAll(expectedList));
	}

	@DisplayName("Создание Stream строк и поиск всех строк, у которых длина равна заданному числу и которые состоят из определенного набора символов")
	@Test
	public void findString() {
		Stream<String> inputStream = Stream.of(
				"вася",
				"коля",
				"петя",
				"оля",
				"якол",
				"яолккк");
		List<String> expectedList = List.of("коля", "якол");
		List<String> actualList = streamHW.findStrings(inputStream, 4, "^[коля]*$");
		assertTrue(expectedList.containsAll(actualList));
	}

	@DisplayName("Создание Stream пар чисел и поиск всех пар, у которых произведение равно заданному числу или которые удовлетворяют другому условию")
	@Test
	public void intsMatcher() {
		Stream<int[]> inputStream = Stream.of(
				new int[]{1, 2},
				new int[]{2, 1},
				new int[]{1, 2, 1},
				new int[]{0, 2});
		List<int[]> expectedList = List.of(
				new int[]{1, 2},
				new int[]{2, 1});
		List<int[]> actualList = streamHW.findByMultiply(inputStream, 2, ints -> ints.length == 2);
		assertTrue(Arrays.deepToString(expectedList.toArray()).contentEquals(Arrays.deepToString(actualList.toArray())));
	}
}