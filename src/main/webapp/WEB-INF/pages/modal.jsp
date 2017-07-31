<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="modal fade bs-example-modal-lg" id="myModal">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">
          <strong><span id="modalTitle">Loading...</span></strong>
        </h4>
      </div>
      <div class="modal-body">
        <div id="dURL">
          <div class="row">
            <div class="col-md-offset-1 col-md-10">
              <table>
                <tr>
                  <td rowspan="4" align="right" width="90px;"><a class="p"><img id="modalImg"></a></td>
                  <td style="padding-left: 10px;">
                    <h5 style="white-space:nowrap;overflow: hidden;text-overflow: ellipsis;">
                      <span class="label label-primary" id="modalYear"></span>&nbsp;<strong><span id="modalName"></span></strong>
                    </h5>
                  </td>
                </tr>
                <tr>
                  <td style="padding-left: 10px;">
                    <span id="modalStaring"></span>
                  </td>
                </tr>
                <tr>
                  <td style="padding-left: 10px;">
                    <span id="modalStatus"></span>&nbsp;&nbsp;&nbsp;
                    <span id="modalArea"></span>&nbsp;&nbsp;&nbsp;
                    <span id="modalType"></span>&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;
                  </td>
                </tr>
                <tr>
                  <td style="padding-left: 10px;">
                    <span class="label label-danger" id="modalLastest"></span>
                  </td>
                </tr>
                <tr><td colspan="2">&nbsp;</td></tr>
                <!--
                <tr>
                  <td colspan="2" style="padding-top:10px;padding-bottom: 10px;">
                    <span id="modalInfo"></span>
                  </td>
                </tr>
                -->
              </table>
            </div>
          </div>
          <!-- Nav tabs -->
          <div class="row">
            <div class="col-md-offset-1 col-md-10">
              <ul id="urlsTab" class="nav nav-tabs" role="tablist">
                <li role="presentation" class="active"><a href="#info" data-toggle="tab"><i class="glyphicon glyphicon-info-sign"></i> Plot Summary</a></li>
                <li role="presentation"><a href="#online" data-toggle="tab"><i class="glyphicon glyphicon-expand"></i> URL Online <span class="badge" id="onlineCount">4</span></a></li>
                <li role="presentation"><a href="#download" data-toggle="tab"><i class="glyphicon glyphicon-save"></i> URL Download <span class="badge" id="downloadCount">5</span></a></li>
                <li role="presentation"><a href="#skydrive" data-toggle="tab"><i class="glyphicon glyphicon-cloud"></i> URL SkyDrive <span class="badge" id="skydriveCount">8</span></a></li>
              </ul>
              <!-- Nav tabs' contents -->
              <div id="urlsTabContent" class="tab-content">
                <div class="tab-pane fade in active" id="info">
                  <table class="table table-hover" id="infoTab">
                    <tr>
                      <td id="modalInfo">Loading...</td>
                    </tr>
                  </table>
                </div>
                <div class="tab-pane fade" id="online">
                  <table class="table table-hover" id="onlineTab">
                    <tr>
                      <td>Loading...</td>
                    </tr>
                  </table>
                </div>
                <div class="tab-pane fade" id="download">
                  <table class="table table-hover" id="downloadTab">
                    <tr>
                      <td style="overflow: hidden;text-overflow: ellipsis;">Loading...</td>
                    </tr>
                  </table>
                  <div class="text-center">右键点击链接并复制链接地址</div>
                </div>
                <div class="tab-pane fade" id="skydrive">
                  <table class="table table-hover" id="skydriveTab">
                    <tr>
                      <td>Loading...</td>
                    </tr>
                  </table>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->