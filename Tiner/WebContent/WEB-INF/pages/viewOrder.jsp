
<script>
function doPost(param){
    window.location.href = window.location.href + "&_eventId=" + param;
}

</script>
<body>  
    <h1>View Cart</h1>  
    <a href="javascript:doPost('confirm')">confirm</a>  
</body>  