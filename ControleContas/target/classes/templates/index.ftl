<!DOCTYPE html>
 
<html lang="en" ng-app="controleContas">
    <head>
        <title>${title}</title>
        <link href="css/bootstrap.css" rel="stylesheet"/>
        <link href="css/app.css" rel="stylesheet"/>
    </head>
    <body>
 
        <div ui-view></div>
        <script src="js/lib/jquery-3.2.1.min.js" ></script>
        <script src="js/lib/jquery-ui.min.js" ></script>
        <script src="js/lib/angular.min.js" ></script>
        <script src="js/lib/angular-ui-router.min.js" ></script>
        <script src="js/lib/localforage.min.js" ></script>
        <script src="js/lib/Chart.min.js"></script>
		<script src="js/lib/angular-chart.js"></script>
        <script src="js/lib/ngStorage.min.js"></script>
        <script src="js/app/app.js"></script>
        <script src="js/app/ContaService.js"></script>
        <script src="js/app/ContaController.js"></script>
    </body>
</html>