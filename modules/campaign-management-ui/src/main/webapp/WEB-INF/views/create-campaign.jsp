
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Create campagin</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <link href="resources/css/bootstrap.css" rel="stylesheet">
    <style type="text/css">
        body {
            padding-top: 60px;
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }
    </style>
    <link href="resources/css/bootstrap-responsive.css" rel="stylesheet">


</head>

<body>

<div class="navbar navbar-inverse navbar-fixed-top">
    <jsp:include page="common/header.jsp"/>
</div>

<div class="container-fluid">
    <div class="row-fluid">
        <jsp:include page="common/side-bar.jsp"/>
        <div class="span9">
            <div class="well">
                <h4>Create Campaign</h4>
                <form role="form" method="post">
                    <div class="form-group">
                        <label for="name">Name</label>
                        <input type="text" class="form-control" id="name" name="name" placeholder="Campaign Name">
                    </div>
                    <div class="form-group">
                        <label for="description">Description</label>
                        <input type="text" class="form-control" id="description" name="description" placeholder="Campaign Description">
                    </div>
                    <div class="form-group">
                        <label for="startDate">Start Date (dd/MM/yyyy)</label>
                        <input type="text" class="form-control" id="startDate" name="startDate" placeholder="01/01/2014">
                    </div>
                    <div class="form-group">
                        <label for="endDate">End Date (dd/MM/yyyy)</label>
                        <input type="text" class="form-control" id="endDate" name="endDate" placeholder="01/01/2014">
                    </div>
                    <div class="form-group">
                        <label for="winnerSelection">Winner Selection</label>
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio" name="winnerSelectionType"  value="IMMEDIATE" checked>
                            Immediate
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio" name="winnerSelectionType" value="END_OF_CAMPAIGN">
                            End of the cycle
                        </label>
                    </div>

                    <div class="form-group">
                        <label for="exampleInputPassword1">Campaign Rule</label>
                        <select class="form-control" name="campaignRule.ruleType">
                            <option value="SMS">SMS</option>
                            <option value="VOICE_CALL">Voice Call</option>
                        </select>

                        <select class="form-control" name="campaignRule.conditionString">
                            <option value="==">==</option>
                            <option value=">">></option>
                            <option value="<"><</option>
                            <option value=">=">>=</option>
                            <option value="<="><=</option>
                        </select>
                        <input type="number" class="form-control" id="campaignRule.count" name="campaignRule.count">
                    </div>

                    <div class="form-group">
                        <label for="smsNotification">SMS Notification</label>
                        <input type="text" class="form-control" name="smsNotification" id="smsNotification" placeholder="Notification Text">
                    </div>




                    <button type="submit" class="btn btn-default">Submit</button>
                </form>


            </div>

        </div><!--/span-->
    </div><!--/row-->

    <hr>

    <footer>
        <p>&copy; Rajith Delantha 2014</p>
    </footer>

</div><!--/.fluid-container-->

<!-- Le javascript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="resources/js/jquery.js"></script>
<script src="resources/js/bootstrap-transition.js"></script>
<script src="resources/js/bootstrap-alert.js"></script>
<script src="resources/js/bootstrap-modal.js"></script>
<script src="resources/js/bootstrap-dropdown.js"></script>
<script src="resources/js/bootstrap-scrollspy.js"></script>
<script src="resources/js/bootstrap-tab.js"></script>
<script src="resources/js/bootstrap-tooltip.js"></script>
<script src="resources/js/bootstrap-popover.js"></script>
<script src="resources/js/bootstrap-button.js"></script>
<script src="resources/js/bootstrap-collapse.js"></script>
<script src="resources/js/bootstrap-carousel.js"></script>
<script src="resources/js/bootstrap-typeahead.js"></script>
<script src="resources/js/jqBootstrapValidation.js"></script>

</body>
</html>
