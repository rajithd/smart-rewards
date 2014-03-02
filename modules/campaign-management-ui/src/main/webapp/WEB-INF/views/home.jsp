<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Home</title>
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
                <h4>Campaign List</h4>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>Campaign Name</th> <th>Campaign Description</th> <th>Campaign Start Date</th> <th>Campaign End Date</th> <th>Winner Selection</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${campaigns}" var="campaign" >
                        <tr>
                            <td><c:out value="${campaign.name}"/></td>
                            <td><c:out value="${campaign.description}"/></td>
                            <td><c:out value="${campaign.startDate}"/></td>
                            <td><c:out value="${campaign.endDate}"/></td>
                            <td><c:out value="${campaign.winnerSelectionType}"/></td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
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
