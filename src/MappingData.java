

import java.util.ArrayList;
import java.util.Random;

public class MappingData {
	public ArrayList<DataModelMain> getDummyData() {
		ArrayList<DataModelMain> data = new ArrayList<DataModelMain>();
		for (int i = 0; i < 60; i++) {
			int randomNumber = new Random().nextInt(9) + 1;
			String color = "";
			if (randomNumber % 2 == 0) {

				color = "R";
			} else {
				color = "R";
			}
			if (i == 38) {
				color = "G";

			}
			if (i == 28) {
				color = "G";

			}

			// print("$i $color,")
			// print(color)
			DataModelMain dataModel = new DataModelMain();
			dataModel.setPeriod(i);
			dataModel.setNumber(randomNumber);
			dataModel.setColor(color);

			data.add(dataModel);
		}

		for (int i = 0; i < data.size(); i++) {

			// System.out.println(i + ":" + data.get(i).getColor());

		}
		return data;

	}
}
