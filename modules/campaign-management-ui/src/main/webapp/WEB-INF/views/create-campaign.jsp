
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
                <form role="form">
                    <div class="form-group">
                        <label for="exampleInputEmail1">Name</label>
                        <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Campaign Name">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Description</label>
                        <input type="text" class="form-control" id="exampleInputPassword1" placeholder="Campaign Description">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Start Date</label>
                        <input type="text" class="form-control" id="exampleInputPassword1" placeholder="01/01/2014">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">End Date</label>
                        <input type="text" class="form-control" id="exampleInputPassword1" placeholder="01/01/2014">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Winner Selection</label>
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>
                            Immediate
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
                            End of the cycle
                        </label>
                    </div>

                    <div class="form-group">
                        <label for="exampleInputPassword1">Campaign Rule</label>
                        <select class="form-control">
                            <option>SMS</option>
                            <option>Voice Call</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                        </select>

                        <select class="form-control">
                            <option>==</option>
                            <option>></option>
                            <option><</option>
                            <option>>=</option>
                            <option><=</option>
                        </select>
                        <input type="text" class="form-control" id="exampleInputPassword1">
                    </div>

                    <div class="form-group">
                        <label for="exampleInputPassword1">SMS Notification</label>
                        <input type="text" class="form-control" id="exampleInputPassword1" placeholder="Notification Text">
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

</body>
</html>
