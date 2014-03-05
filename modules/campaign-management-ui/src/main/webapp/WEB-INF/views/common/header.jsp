<%@ page import="com.cmr.cm.util.SecurityHolder" %>
<div class="navbar-inner">
    <div class="container-fluid">
        <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>

        <div class="nav-collapse collapse">
            <p class="navbar-text pull-right">
                Logged in as <a href="#" class="navbar-link"> <%= SecurityHolder.getUsername()%></a>
            </p>

        </div><!--/.nav-collapse -->
    </div>
</div>