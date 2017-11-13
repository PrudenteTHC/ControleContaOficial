<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading">
        	<span class="lead">Lançamentos</span>
        	<input type="button" class="btn btn-primary btn-sm floatRight" value="Incluir Lançamento" ng-click="showHide()" />
        </div>
        <div class="panel-body">
            <div class="table-responsive">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>Descrição</th>
                        <th>Valor</th>
                        <th>Vencimento</th>
                        <th>Tipo</th>
                        <th width="100"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr ng-repeat="d in ctrl.getAllContas()">
                        <td>{{d.descricao}}</td>
                        <td>{{d.valor | currency:"R$"}}</td>
                        <td>{{d.vencFormatted | dateOnly}}</td>
                        <td ng-class="getClass(d.tipo)">{{d.tipo == true ? "Receita" : "Despesa"}}</td>
                        <td><button type="button" ng-click="ctrl.removeConta(d.id)" class="btn btn-danger custom-width">Remover</button></td>
                    </tr>
                    </tbody>
                </table>      
                <input type="hidden" name="sumReceita" class="sumReceita" value="{{ctrl.getAllContas() | sumByColumn: 'valor':true:this}}"/>
             	<input type="hidden" name="sumDespesas" class="sumDespesas" value="{{ctrl.getAllContas() | sumByColumn: 'valor':false:this}}"/>
            </div>
        </div>
    </div>

    <div class="panel panel-default" ng-show="isVisible">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Incluir Lançamento</span></div>
        <div class="panel-body">
            <div class="formcontainer">
                <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
                <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
                <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                    <input type="hidden" ng-model="ctrl.conta.id" />
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="uname">Descrição</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.conta.descricao" id="desc" class="username form-control input-sm" placeholder="Descrição do Lançamento" required/>
                            </div>
                        </div>
                    </div>
 
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="valor">Valor</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.conta.valor" id="valor" class="form-control input-sm" placeholder="Valor da Despesa" required/>
                            </div>
                        </div>
                    </div>
                    
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="datav">Data de Vencimento</label>
                            <div class="col-md-7">
                                <input type="date" placeholder="dd-MM-yyyy" ng-model="ctrl.conta.vencimento" id="venct" class="form-control input-sm" placeholder="Data de Vencimento"  required />
                            </div>
                        </div>
                    </div>
     				
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="tipo">Tipo</label>
                            <div class="col-md-7">
                            <label>
                            		<input type="radio" name="radiogroup" ng-model="ctrl.conta.tipo" value="true" required >
    								Receita
  							</label>
  							 <label>
                            		<input type="radio" name="radiogroup" ng-model="ctrl.conta.tipo" value="false" required >
    						Despesa
  							</label>
                            </div>
                        </div>
                    </div>
 
                    <div class="row">
                        <div class="form-actions floatRight">
                            <input type="submit" value="Adicionar" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid || myForm.$pristine">
                            <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Limpar Campos</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>    
    </div>
    
        <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading">
        	<span class="lead">Gráfico de Lançamentos</span>
        </div>
        <div class="panel-body">
            <div class="table-responsive" >
                	<canvas id="pie" class="chart chart-pie" chart-data="data" chart-labels="labels" chart-legend="true" chart-options="options">
					</canvas>
            </div>
        </div>
    </div>
   
</div>