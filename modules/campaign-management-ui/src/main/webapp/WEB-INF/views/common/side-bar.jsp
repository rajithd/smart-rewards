<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<div class="span3">
    <div class="well sidebar-nav">
        <ul class="nav nav-list">
            <li class="nav-header">Campaign</li>
            <li><a href="home">Home</a></li>
            <li><a href="create-campaign">Create Campaign</a></li>
            <li class="nav-header">Profile</li>
            <sec:authorize ifAnyGranted="ROLE_ADMIN">
                <li><a href="create-user">Create User</a></li>
            </sec:authorize>
            <li><a href="#">Link</a></li>
            <li><a href="#">Link</a></li>
            <li><a href="#">Link</a></li>
            <li><a href="#">Link</a></li>
            <li><a href="#">Link</a></li>

        </ul>
    </div><!--/.well -->
</div>