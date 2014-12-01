function addRow(tableID) {
            var table = document.getElementById(tableID);
 
            var rowCount = table.rows.length;
            var row = table.insertRow(rowCount);
 
            var cell1 = row.insertCell(0);
            var element1 = document.createElement("input");
            element1.type = "checkbox";            
            cell1.appendChild(element1);
 
            var cell2 = row.insertCell(1);
            cell2.innerHTML = rowCount + 1;
 
            var cell3 = row.insertCell(2);
            var element2 = document.createElement("input");
            element2.type = "text";
            element2.name = "question.answers.answerContent";
            element2.width="300";
            element2.className="textfield";
            cell3.appendChild(element2);
        }
 
    function deleteRow(tableID) {
        try {
            var table = document.getElementById(tableID);
            var rowCount = table.rows.length;
 
            for(var i=0; i<rowCount; i++) {
                var row = table.rows[i];
                var chkbox = row.cells[0].childNodes[0];
                if(null != chkbox && chkbox.checked) {
                    table.deleteRow(i);
                    rowCount--;
                    i--;
                }
                var j=i;
                if(j<0){
					j=0;
		        }
		        if(rowCount>0){
	                var row1=table.rows[j];
	                var cell=row1.cells[1];
	                cell.innerHTML=i+1
		        }
        	}      
        }catch(e) {
            alert(e);
        }
    }
    
    function checkFinishStep2() {
        try {
            var table = document.getElementById('dataTable');
        var rowCount = table.rows.length;
        
        /**
         * Kiem tra truong hop chon kieu cau hoi bat buoc phai nhop
         * cau tra loi.
         */
        if(document.getElementById('typeOfQuestionID').value!=3){
        	if(rowCount==0){
        		alert("Ban phai nhap cac cau tra loi!");
        		return false;
        	}
        }
        
        /**
         * Kiem tra du lieu truong "noi dung cau hoi"
         */
        if(document.getElementById('questionContent').value==""){
        	alert("Ban phai nhap noi dung cau hoi!");
    		return false;
        }
        
        /**
         * Kiem tra truong hop chon kieu cau hoi ma nguoi
         * dung tu nhap cau tra loi
         */
        if(document.getElementById('typeOfQuestionID').value==3){
        	if(rowCount!=0){
        		var answer = confirm("Ban dang chon kieu cau hoi ma nguoi dung tu nhap cau tra loi. He thong se tu dong xoa cac cau tra loi ma ban da nhap neu ban tiep tuc!")
        		if (answer){
        			while(rowCount){              
     	                   table.deleteRow(0);
     	                   rowCount--;
     	            }
        			return true;
        		}
        		else{
        			return false;
        		}
        		
        	}
        }
        
        /**
         * Kiem tra du lieu truong "Noi dung cau tra loi."
         */
        for(var i=0; i<rowCount; i++) {
            var row = table.rows[i];
            var textbox = row.cells[2].childNodes[0];
            if(null != textbox && textbox.value=="") {
            	alert("Ban phai nhap noi dung cac cau tra loi!");
            	return false;
            }
    	}      
    }catch(e) {
        alert(e);
    }
}


function checkFinishStep1() {
    try {
                    
        /**
         * Kiem tra du lieu truong "tieu de cuoc khao sat"
         */
        if(document.getElementById('title').value==""){
        	alert("Ban phai nhap tieu de cua cuoc khao sat!");
    		return false;
        }
        
        /**
         * Kiem tra du lieu truong "mo ta cuoc khao sat"
         */
        if(document.getElementById('description').value==""){
        	alert("Ban phai mo ta so luoc ve cuoc khao sat!");
    		return false;
        }
    }catch(e) {
        alert(e);
    }
}

function checkFinishStep3() {
    try {
    
         var beginTime=document.getElementById('beginTime').value;
         var andTime=document.getElementById('endTime').value;
         var stDate = new Date(beginTime);
         var enDate = new Date(andTime);
        /**
         * Kiem tra du lieu truong "tieu de cuoc khao sat"
         */
        if(beginTime==""){
        	alert("Ban phai nhap ngay bat dau cuoc khao sat!");
    		return false;
        }
        
        /**
         * Kiem tra du lieu truong "mo ta cuoc khao sat"
         */
        if(andTime==""){
        	alert("Ban phai nhap ngay ket thuc cuoc khao sat!");
    		return false;
        }
        if(stDate>enDate){ alert("Ngay bat dau phai be hon ngay ket thuc!");
		return false;}
        
    }catch(e) {
        alert("Du lieu khong hop le, vui long kiem tra lai.");
        return false;
    } 
}

function checDeleteQuestion() {
	 try {
         var table = document.getElementById("mytable");
         var rowCount = table.rows.length;
         var flag=0;
         for(var i=0; i<rowCount; i++) {
             var row = table.rows[i];
             var chkbox = row.cells[0].childNodes[0];
             if(null != chkbox && chkbox.checked) {
                 flag++;
             }
     	}      
        if(flag==0){
        	alert("Ban vui long chon cau hoi can xoa!");
        	return false;
        }
     }catch(e) {
         alert(e);
     }
     return true;
}
        
        
        
       
