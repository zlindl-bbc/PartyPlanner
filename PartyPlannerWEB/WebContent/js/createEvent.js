function newProductRow() {
	var th = document.querySelectorAll('#table th');

	if (!th.length) {
		document.getElementById("saveButton").disabled = false;
		var rows = "<th>Produktname</th><th>Anzahl</th>";
		var table = document.createElement('table');
		table.innerHTML = rows;
		document.getElementById("table").appendChild(table.firstChild);
	}

	var newRow = "<tr><th><input type='text' placeholder='Produktname'></th><th><input type='number' min='0' step='1' value='0' required></th></tr>";
	var table = document.createElement('table');
	table.innerHTML = newRow;
	document.getElementById("table").appendChild(table.firstChild);
}