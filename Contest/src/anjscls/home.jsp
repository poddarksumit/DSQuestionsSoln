<div ng-controller="HomeContent">
	<table>
		<tbody>
			<tr ng-repeat="content in contents">
				<td><a href="{{content.link}}" target="_blank">{{content.text}}</a>
				</td>
			</tr>
		</tbody>
	</table>
	
</div>