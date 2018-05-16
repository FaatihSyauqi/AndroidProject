<!DOCTYPE html>
<html>
	
	<head>
		<meta charset="UTF-8">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>Visit The City</title>
		<!-- Favicon-->
		<link rel="icon" href="styles/favicon.ico" type="image/x-icon">
		<link rel="shortcut icon" href="styles/images/ic_launcher.ico" type="image/x-icon">
		<!-- Google Fonts -->
		<link href="https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext" rel="stylesheet" type="text/css">
		<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" type="text/css">
		
		<link href='styles/plugins/font-awesome/css/font-awesome.min.css' rel='stylesheet' />
		
		<!-- Bootstrap Core Css -->
		<link href="styles/plugins/bootstrap/css/bootstrap.css" rel="stylesheet">
		
		<!-- Waves Effect Css -->
		<link href="styles/plugins/node-waves/waves.css" rel="stylesheet" />
		
		<!-- Animation Css -->
		<link href="styles/plugins/animate-css/animate.css" rel="stylesheet" />
		
		<link href="styles/plugins/sweetalert/sweetalert.css" rel="stylesheet" />
		
		<!-- JQuery DataTable Css -->
		<link href="styles/plugins/jquery-datatable/skin/bootstrap/css/dataTables.bootstrap.css" rel="stylesheet">
		
		<!-- Custom Css -->
		<link href="styles/css/style.css" rel="stylesheet">
		
		<!-- AdminBSB Themes. You can choose a theme from css/themes instead of get all themes -->
		<link href="styles/css/themes/all-themes.css" rel="stylesheet" />
		
		
	</head>
	<body class="theme-indigo">
		<!-- Page Loader -->
		<div class="page-loader-wrapper">
			<div class="loader">
				<div class="preloader">
					<div class="spinner-layer pl-indigo">
						<div class="circle-clipper left">
							<div class="circle"></div>
						</div>
						<div class="circle-clipper right">
							<div class="circle"></div>
						</div>
					</div>
				</div>
				<p>Please wait...</p>
			</div>
		</div>
		<!-- #END# Page Loader -->
		<!-- Overlay For Sidebars -->
		<div class="overlay"></div>
		<!-- #END# Overlay For Sidebars -->
		<!-- Search Bar -->
		<div class="search-bar">
			<div class="search-icon">
				<i class="material-icons">search</i>
			</div>
			<form id="searchForm" action="" method="get">
				<input type="text" id="frmSearch" name="search" placeholder="START TYPING...">
				<input type="submit" style="display:none"/>
			</form>
			<div class="close-search">
				<i class="material-icons">close</i>
			</div>
		</div>
		<!-- #END# Search Bar -->
		<!-- Top Bar -->
		<nav class="navbar">
			<div class="container-fluid">
				
				<div class="navbar-header">
					<a href="javascript:void(0);" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse" aria-expanded="false"></a>
					<a href="javascript:void(0);" class="bars"></a>
					<a class="navbar-brand" id="titlePage" href="home">City App</a>
					
				</div>
				<div class="collapse navbar-collapse" id="navbar-collapse">
					<ul class="nav navbar-nav navbar-right">
						<!-- Call Search -->
						<li><a href="javascript:void(0);" class="js-search" data-close="true"><i class="material-icons">search</i></a></li>
						<!-- #END# Call Search -->
						<li>
							<a href="add">
								<i class="material-icons">add_circle</i>
							</a>
						</li>
						
						<li class="dropdown">
							<a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown" role="button">
								<i class="material-icons">menu</i>
							</a>
							<ul class="dropdown-menu">
								<li class="header">CATEGORIES</li>
								<li class="body" id="menuCategory">
									<ul class="menu menu-list" >
										
									</ul>
								</li>
							</ul>
						</li>
					</ul>
				</div>
			</div>
		</nav>
		<!-- #Top Bar -->
		<section>
			<!-- Left Sidebar -->
			<aside id="leftsidebar" class="sidebar">
				<!-- User Info -->
				<div class="user-info">
					<div class="image">
						<img src="styles/images/user.png" width="48" height="48" alt="User" />
					</div>
					<div class="info-container">
						<div id="user" class="name" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Demo Admin</div>
						<div id="email" class="email">admin@cityapp.com</div>
						<div class="btn-group user-helper-dropdown">
							<i class="material-icons" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">keyboard_arrow_down</i>
							<ul class="dropdown-menu pull-right">
								<li><a id="logoutBtn"><i class="material-icons">input</i>Sign Out</a></li>
							</ul>
						</div>
					</div>
				</div>
				<!-- #User Info -->
				<!-- Menu -->
				<div class="menu">
					<ul class="list">
						<li class="header">MAIN NAVIGATION</li>
						
						<li class="active">
							<a href="home">
								<i class="material-icons">layers</i>
								<span>All Places</span>
							</a>
						</li>
						<li>
							<a href="categories">
								<i class="material-icons">list</i>
								<span>Categories</span>
							</a>
						</li>
						
						<li>
							<a href="config">
								<i class="material-icons">settings</i>
								<span>Configuration</span>
							</a>
						</li>
					</ul>
				</div>
				
			</aside>
			<!-- #END# Left Sidebar -->
			
		</section>
		
		<section class="content">
			
			<div class="container-fluid">
				
				<center>
					<div id="loading">
						<div class="preloader pl-size-sm" style="margin:0 auto;">
							<div class="spinner-layer pl-indigo">
								<div class="circle-clipper left">
									<div class="circle"></div>
								</div>
								<div class="circle-clipper right">
									<div class="circle"></div>
								</div>
							</div>
							
						</div>
						<p>Please wait...</p>
					</div>
				</center>
				
				
				<div class="row clearfix" id="allplacedata" >
					<div class="data-list">
					</div>
				</div>
				
				<div class="row clearfix">	
					
					<div class="col-sm-6">
						<div class="card" id="placedata" style="display:none">
							
							<div class="body">
								<div class="row clearfix">
									<form id="saveForm" action="#" name="svForm">
										<div class="col-sm-12">
											
											<div class="form-group">
												<div class="form-line">
													<img id="imgThumb" width="100%" height="250px"/>
												</div>
											</div>
											
											
											<b>Place Name</b>
											<div class="form-group">
												<div class="form-line">
													<input type="text" id="frmPlaceName" class="form-control" placeholder="Place Name" required/>
												</div>
											</div>
											
											<b>Address</b>
											<div class="form-group">
												<div class="form-line">
													<input type="text" id="frmAddress" class="form-control" placeholder="Address" />
												</div>
											</div>
											
											<b>Description  <small>(Use html tag)</small></b>
											<div class="form-group">
												<div class="form-line">
													<textarea id="frmDescription" class="form-control" rows="6" placeholder="Facilities"></textarea>
												</div>
											</div>
											
											<b>Facilities</b>
											<div class="form-group">
												<div class="form-line">
													<input type="text" id="frmFacilities" class="form-control" placeholder="Facilities" />
												</div>
											</div>
											
											<b>Info</b>
											<div class="form-group">
												<div class="form-line">
													<input type="text" id="frmInfo" class="form-control" placeholder="Info" />
												</div>
											</div>
											
											<b>Location</b>
											<div class="form-group">
												<div class="col-sm-5">
													<div class="form-line">
														<input type="text" id="frmLatitude" class="form-control" placeholder="Latitude" required/>
													</div>
												</div>
												<div class="col-sm-5">
													<div class="form-line">
														<input type="text" id="frmLongitude" class="form-control" placeholder="Longitude" required/>
													</div>
												</div>
												<div class="col-sm-2">
													<a href="http://www.mapcoordinates.net/en" target="_blank" class="btn bg-blue-grey btn-block waves-effect"><i class="material-icons">place</i></a>
												</div>
											</div>
											
											<b>Change Image</b>
											<div class="form-group">
												<div class="form-line">
													<input type="file" name="fImage" id="frmImage" class="form-control" placeholder="filename" />
												</div>
											</div>
											
											<b>Category</b>
											<br><br>
											<div class="form-line" id="category-list">
												<div class="category-data">
												</div>
											</div>
											
											
											<input type="submit" class="btn btn-primary btn-lg btn-block m-t-15 waves-effect" value="SAVE"/>
											<br><br><center>
											<div id="loading-save" style="display:none" class="preloader pl-size-xs">
												<div class="spinner-layer pl-light-blue">
													<div class="circle-clipper left">
														<div class="circle"></div>
													</div>
													<div class="circle-clipper right">
														<div class="circle"></div>
													</div>
												</div>
											</div>
											</center>
											
										</form>
										
										
										
									</div>
								</div>
							</div>
						</div>
					</div>
					
					<div class="col-sm-6" id="comenSec" style="display:none">
						
						<div class="card">
							<div class="body">
								<ul class="nav nav-tabs" role="tablist">
									<li role="presentation" class="active">
										<a href="#reviews" data-toggle="tab">
											<i class="material-icons">rate_review</i> REVIEWS
										</a>
									</li>
									<li role="presentation">
										<a href="#gallery" data-toggle="tab">
											<i class="material-icons">collections</i> GALLERY
										</a>
									</li>
									
								</ul>
								
								<div class="tab-content">
									<div role="tabpanel" class="tab-pane fade in active" id="reviews">
										<div class="review-list">
										</div>
									</div>
									
									<div role="tabpanel" class="tab-pane fade" id="gallery">
										<div id="aniimated-thumbnials" class="list-unstyled row clearfix">
											<div class="gallery-list">
											</div>
										</div>
									</div>
								</div>
								
							</div>
							
							
						</div>
						
					</div>
					
				</div>
				
			</div>
			
		</section>
		
		
		
		<!-- Jquery Core Js -->
		<script src="styles/plugins/jquery/jquery.min.js"></script>
		<!-- Bootstrap Core Js -->
		<script src="styles/plugins/bootstrap/js/bootstrap.js"></script>
		
		<!-- Select Plugin Js -->
		<script src="styles/plugins/bootstrap-select/js/bootstrap-select.js"></script>
		
		<!-- Slimscroll Plugin Js -->
		<script src="styles/plugins/jquery-slimscroll/jquery.slimscroll.js"></script>
		
		<!-- Waves Effect Plugin Js -->
		<script src="styles/plugins/node-waves/waves.js"></script>
		
		<script src="styles/plugins/bootstrap-notify/bootstrap-notify.js"></script>
		
		<script src="styles/plugins/light-gallery/js/lightgallery-all.js"></script>
		<script src="styles/js/pages/medias/image-gallery.js"></script>
		<script src="styles/plugins/tinymce/tinymce.js"></script>
		<!--
			<script>tinymce.init({ 
			mode : 'specific_textareas',
			menubar: false,
			elements : "frmDescription",
			plugins: [
			'advlist autolink lists link image charmap print preview anchor',
			'searchreplace visualblocks code fullscreen',
			'insertdatetime media table contextmenu paste code'
			],
			toolbar: 'undo redo | insert | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link',
			valid_elements : "i,sub,sup",
			invalid_elements : "p, script",
			});</script>
			
		<!-- SweetAlert Plugin Js -->
		<script src="styles/plugins/sweetalert/sweetalert.min.js"></script>
		<!-- Custom Js -->
		<script src="styles/js/admin.js"></script>
		
		<!-- Demo Js -->
		<script src="styles/js/demo.js"></script>
		
		
		<!-- FIREBASE -->
		<script src="https://www.gstatic.com/firebasejs/3.7.5/firebase.js"></script>
		
		<script src="scripts/firebase.js"></script>
		<script src="scripts/index.js"></script>
		
		
	</body>
	
</html>			