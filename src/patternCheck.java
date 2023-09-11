

import java.util.ArrayList;

public class patternCheck {
	int matchingClear = 0;
	int serialCheck = 6;
	int serialNext = 0;
	int loopMax = 0;
	int serialNumberPositionMoveForward = 0;
	int serialNumberPosition = 0;
	boolean serialEnable = false;

	ArrayList<Integer> serialNumberList = new ArrayList<>();
	ArrayList<DataModelMain> dataList = new MappingData().getDummyData();
	ArrayList<String> finalResult = new ArrayList<>();
	StringBuilder colorBuilder = new StringBuilder();

	StringBuilder periodBuilder = new StringBuilder();
	StringBuilder numberBuild = new StringBuilder();

	String matchValue = "";
	String currentColor = "";

	public void patternCheckBasedOnSerialNumber() {
		prepareSerialNumber();
		DataModelMain valueCurrent = dataList.get(0);
		matchValue = valueCurrent.getColor();
		picSerialNumberBasics();

	}

	public void picSerialNumberBasics() {
		// for (int serialNumberPositionMoveForward = 0; serialNumberPositionMoveForward
		// < serialNumberList .size(); serialNumberPositionMoveForward++) {
		while (serialNumberPositionMoveForward < serialNumberList.size()) {
			System.out.println("EXT 1->" + serialNumberPositionMoveForward);

			serialNumberPosition = serialNumberList.get(serialNumberPositionMoveForward);
			System.out.println("picSerialNumberBasics->" + serialNumberPositionMoveForward + ":");

			getMatch(serialNumberPosition, serialNumberPositionMoveForward);
			serialNumberPositionMoveForward++;
		}
		for (int k = 0; k < finalResult.size(); k++) {
			System.out.println(finalResult.get(k));
		}

	}

	public void getMatch(int startPosition, int matchPosition) {
		String matchValue = dataList.get(matchPosition).getColor();
		String currentColor = "";
		StringBuilder value = new StringBuilder();
		loopMax = 0;
		for (int i = startPosition; i < dataList.size(); i++) {
			currentColor = dataList.get(i).getColor();
			if (matchValue.equals(currentColor)) {
				loopMax++;

				// System.out.println(" if getMatch->" + matchValue + ":" + currentColor + ":" +
				// i);

				value
						// .append("P->")
						.append(dataList.get(i).getPeriod()).append("\t")
						// .append("N->")
						.append(dataList.get(i).getNumber()).append(" ")
						// .append("C->")
						.append(currentColor).append("\n");
				matchingClear++;
				if (i == dataList.size() - 1) {
					addValue(value.toString());

				}
			} else {
				// System.out.println(" else getMatch->" + matchValue + ":" + currentColor + ":"
				// + i);

				addValue(value.toString());
				value.setLength(0);
				matchValue = currentColor;
				value
						// .append("P->")
						.append(dataList.get(i).getPeriod()).append("\t")
						// .append("N->")
						.append(dataList.get(i).getNumber()).append(" ")
						// .append("C->")
						.append(matchValue).append(" ");

				int lp = loopMax + serialCheck;
				if (lp >= dataList.get(i).getPeriod()) {
				 System.out.println("EXTeeee->" + (loopMax + serialCheck) + ":" + i + ":" +
					dataList.get(i).getPeriod());
					loopMax = 0;
					System.out.println("EXT 2->" + serialNumberPositionMoveForward);
					System.out.println("EXT 3->" + serialNumberPositionMoveForward + "\n");
					serialNumberPositionMoveForward++;
				}
				break;
			}
		}
	}

	public void pickData(int startPosition_) {
		colorBuilder = new StringBuilder(matchValue);
		matchingClear = 0;

		for (int i = startPosition_; i < dataList.size(); i++) {

			currentColor = dataList.get(i).getColor();
			retrieve(i, dataList.size(), dataList.get(i));

		}
	}

	public void retrieve(int i, int listSize, DataModelMain data) {
		if (matchValue.equals(currentColor)) {
			colorBuilder.append(data.getPeriod()).append(":").append(data.getNumber()).append(":").append(currentColor)
					.append("->");
			matchingClear++;
			if (i == listSize - 1) {
				addValue(colorBuilder.toString());
			}
		} else {
			addValue(colorBuilder.toString());
			colorBuilder.setLength(0);
			matchValue = currentColor;
			colorBuilder.append(data.getPeriod()).append(":").append(data.getNumber()).append(":").append(matchValue)
					.append("->");
		}
	}

	public void addValue(String value) {
		if (matchingClear >= 0) {
			finalResult.add(value);
		}
		matchingClear = 0;
	}

	public void addValue_(String value) {
		if (matchingClear >= 0) {
			finalResult.add(value);
		}
		matchingClear = 0;
	}

	public void print(String str) {
		System.out.println(str);
	}

	public void prepareSerialNumber() {

		serialNext = serialCheck;
		serialNumberList.add(serialNext);
		for (int i = 0; i < dataList.size(); i++) {

			if (serialCheck == (dataList.get(i).getPeriod()) % 10) {
				// System.out.println("prepareSerialNumber-->" + serialCheck + ":" +
				// dataList.get(i).getPeriod());

				serialEnable = true;
				serialNext += 10;
				// System.out.println("Serial--" + serialCheck + ":Next->" + serialNext + ":" +
				// i);
				if (serialNext < dataList.size()) {
					serialNumberList.add(serialNext);
				}
			}
		}

		for (int i = 0; i < serialNumberList.size(); i++) {
			// System.out.println("serialNumberList--" + serialNumberList.get(i));
		}
	}
}
