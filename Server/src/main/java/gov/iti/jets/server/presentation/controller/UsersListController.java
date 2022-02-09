/*
 * Copyright (C) 2022 Parisi Alessandro
 * This file is part of MaterialFX (https://github.com/palexdev/MaterialFX).
 *
 * MaterialFX is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * MaterialFX is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with MaterialFX.  If not, see <http://www.gnu.org/licenses/>.
 */

package gov.iti.jets.server.presentation.controller;

import gov.iti.jets.server.presentation.model.UserModel;
import gov.iti.jets.server.presentation.util.UserFactory;
import io.github.palexdev.materialfx.controls.MFXTableColumn;
import io.github.palexdev.materialfx.controls.MFXTableView;
import io.github.palexdev.materialfx.controls.cell.MFXTableRowCell;
import io.github.palexdev.materialfx.filter.StringFilter;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;

public class UsersListController implements Initializable {

	@FXML
	private MFXTableView<UserModel> table;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setupTable();
		table.autosizeColumnsOnInitialization();
	}

	private void setupTable() {
		MFXTableColumn<UserModel> phoneNumber = new MFXTableColumn<>("PhoneNumber", true, Comparator.comparing(UserModel::getNumber));
		MFXTableColumn<UserModel> firstName = new MFXTableColumn<>("FirstName", true, Comparator.comparing(UserModel::getFirstName));
		MFXTableColumn<UserModel> lastName = new MFXTableColumn<>("LastName", true, Comparator.comparing(UserModel::getLastName));
		MFXTableColumn<UserModel> email = new MFXTableColumn<>("Email", true, Comparator.comparing(UserModel::getEmail));
		MFXTableColumn<UserModel> country = new MFXTableColumn<>("Country", true, Comparator.comparing(UserModel::getCountry));
		MFXTableColumn<UserModel> state = new MFXTableColumn<>("State", true, Comparator.comparing(UserModel::getState));

		phoneNumber.setRowCellFactory(person -> new MFXTableRowCell<>(UserModel::getNumber));
		firstName.setRowCellFactory(person -> new MFXTableRowCell<>(UserModel::getFirstName));
		lastName.setRowCellFactory(person -> new MFXTableRowCell<>(UserModel::getLastName));
		email.setRowCellFactory(person -> new MFXTableRowCell<>(UserModel::getEmail));
		country.setRowCellFactory(person -> new MFXTableRowCell<>(UserModel::getCountry));
		state.setRowCellFactory(person -> new MFXTableRowCell<>(UserModel::getState));

//		ageColumn.setRowCellFactory(person -> new MFXTableRowCell<>(UserModel::getAge) {{
//			setAlignment(Pos.CENTER_RIGHT);
//		}});
		table.getTableColumns().addAll(phoneNumber, firstName, lastName, email, country, state);
		table.getFilters().addAll(
				new StringFilter<>("PhoneNumber", UserModel::getNumber),
				new StringFilter<>("Country", UserModel::getCountry)
		);
		table.setItems(UserFactory.users());
	}
}
