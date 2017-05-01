<div>
	<button class="accordion" style="background-color: ;">Master Screens</button>
	<div class="panel">
		<table style="width: 100%;">
			<tr>
				<td class="leftPanelHeader"><a href="javascript:render('1');">Customer
						Master</a></td>
			</tr>
			<tr>
				<td><hr></hr></td>
			</tr>
			<tr>
				<td class="leftPanelHeader"><a href="javascript:render('2');">Customer
						Search Details</a></td>
			</tr>

			<tr>
				<td><hr></hr></td>
			</tr>
			<tr>
				<td class="leftPanelHeader"><a href="javascript:render('3');">Customer
						Address Details</a></td>
			</tr>
			<tr>
				<td><hr></hr></td>
			</tr>

		</table>
	</div>



	<button class="accordion">Section 2</button>
	<div class="panel">
	<table>
	<tr>
				<td class="leftPanelHeader"><a href="javascript:render('3');">Customer
						Address Details</a></td>
			</tr>
	</table>
	
	</div>

	<button class="accordion">Section 3</button>


	<div class="panel">
	
	<table>
	<tr>
				<td class="leftPanelHeader"><a href="javascript:render('3');">Customer
						Address Details</a></td>
			</tr>
	</table>
	
	
	</div>
</div>

<style>
button.accordion {
	background-color: #ffffff;
	color: #444;
	cursor: pointer;
	padding: 18px;
	width: 100%;
	border: solid 1 px;
	text-align: left;
	outline: none;
	font-size: 15px;
	transition: 0.4s;
}

button.accordion.active, button.accordion:hover {
	background-color: #ddd;
}

div.panel {
	padding: 0 18px;
	background-color: white;
	max-height: 0;
	overflow: hidden;
	transition: max-height 0.2s ease-out;
}
</style>
<script>
	var acc = document.getElementsByClassName("accordion");
	var i;

	for (i = 0; i < acc.length; i++) {
		acc[i].onclick = function() {
			this.classList.toggle("active");
			var panel = this.nextElementSibling;
			if (panel.style.maxHeight) {
				panel.style.maxHeight = null;
			} else {
				panel.style.maxHeight = panel.scrollHeight + "px";
			}
		}
	}
</script>