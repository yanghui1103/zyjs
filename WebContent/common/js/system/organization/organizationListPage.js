/**
 * 组织管理JS
 */

var zNodes ='';

var setting = {
			data: {
				key: {
					title: "t"
				},
				simpleData: {
					enable: true
				}				
			},
			view: {
				fontCss: getFontCss
			},
			callback: {
				onClick: this.onClick
			}
		};

		function focusKey(e) {
			if (key.hasClass("empty")) {
				key.removeClass("empty");
			}
		}
		function blurKey(e) {
			if (key.get(0).value === "") {
				key.addClass("empty");
			}
		}
		var lastValue = "", nodeList = [], fontCss = {};
		function clickRadio(e) {
			lastValue = "";
			searchNode(e);
		}

		function onClick(e, treeId, node) {
			var orgId = node.id;
			$.ajax({
				type : 'GET',
				url : ctx + "org/organization/"+orgId,
				data : {},
				success : function(data) {
					if(data.res=="2"){
						printOrgDetailInfo(data.org);
					}else{
						promptMessage(data.res,data.msg) ;
					}
				},
				error:function(XMLHttpRequest, textStatus, errorThrown){
					$.messager.alert({
			            title: '提示信息',
			            ok: '确定',
			            icon: 'error',
			            cancel: '取消',
			            msg: errorThrown
			          });
				},
				dataType : "JSON"
			});
		}
		
		function searchNode(e) {
			var zTree = $.fn.zTree.getZTreeObj("orgTree");
			if (!$("#getNodesByFilter").attr("checked")) {
				var value = $.trim(key.get(0).value);
				var keyType = "";
				if ($("#name").attr("checked")) {
					keyType = "name";
				} else if ($("#level").attr("checked")) {
					keyType = "level";
					value = parseInt(value);
				} else if ($("#id").attr("checked")) {
					keyType = "id";
					value = parseInt(value);
				}
				if (key.hasClass("empty")) {
					value = "";
				}
				if (lastValue === value) return;
				lastValue = value;
				if (value === "") return;
				updateNodes(false);

				if ($("#getNodeByParam").attr("checked")) {
					var node = zTree.getNodeByParam(keyType, value);
					if (node === null) {
						nodeList = [];
					} else {
						nodeList = [node];
					}
				} else if ($("#getNodesByParam").attr("checked")) {
					nodeList = zTree.getNodesByParam(keyType, value);
				} else if ($("#getNodesByParamFuzzy").attr("checked")) {
					nodeList = zTree.getNodesByParamFuzzy(keyType, value);
				}
			} else {
				updateNodes(false);
				nodeList = zTree.getNodesByFilter(filter);
			}
			updateNodes(true);

		}
		function updateNodes(highlight) {
			var zTree = $.fn.zTree.getZTreeObj("orgTree");
			for( var i=0, l=nodeList.length; i<l; i++) {
				nodeList[i].highlight = highlight;
				zTree.updateNode(nodeList[i]);
			}
		}
		function getFontCss(treeId, treeNode) {
			return (!!treeNode.highlight) ? {color:"#A60000", "font-weight":"bold"} : {color:"#333", "font-weight":"normal"};
		}
		function filter(node) {
			return !node.isParent && node.isFirstNode;
		}

		var key;
		$(document).ready(function(){		
			$.get(ctx+"org/organizations",function(data){ 
				if(data.res =="2"){ 
					zNodes = (data.list) ; 					
					$.fn.zTree.init($("#orgTree"), setting, zNodes);
					key = $("#key");
					key.bind("focus", focusKey)
					.bind("blur", blurKey)
					.bind("propertychange", searchNode)
					.bind("input", searchNode);
					$("#name").bind("change", clickRadio);
					$("#level").bind("change", clickRadio);
					$("#id").bind("change", clickRadio); 
					$("#getNodesByParamFuzzy").bind("change", clickRadio); 
				}
			});
			
		});