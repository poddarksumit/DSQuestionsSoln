/*
This JS class is written to sort the keys of the object in the ascending order.
Similar to TreeMap of JAVA. Using Red-Black Tree
 */
function TreeMapJSNode(object) {
	this.key = object;
	this.color = 'b'; // 'b':Black and 'r':Red
	this.values = {};
	this.left = null;
	this.right = null;
	this.parent = null;
};

function TreeMapJS(object) {
	/* Tree root. */
	this.root = null;
	this.inorderArray = {};
	this.size = 0;

	/* Tree: add. */
	this.add = function(key, values) {
		var node = null;
		var compareVal = 2;
		var rootTemp = this.root;
		while (rootTemp != null) {
			node = rootTemp;
			compareVal = this.compare(rootTemp.key, key);
			if (compareVal == -1) {
				rootTemp = rootTemp.right;
			} else if (compareVal == 1) {
				rootTemp = rootTemp.left;
			} else {
				rootTemp = null;
			}
		}
		if (compareVal == 0) {
			var arrayList = node.values;
			arrayList[arrayList.length] = values;
			node.values = arrayList;
		} else {
			this.size += 1;
			var newNode = new TreeMapJSNode(key);
			newNode.color = 'r';
			newNode.parent = node;
			var arrayList = new Array();
			arrayList[0] = values;
			newNode.values = arrayList;
			if (this.root == null) {
				newNode.color = 'b';
				this.root = newNode;
			} else if (compareVal == 1) {
				node.left = newNode;
			} else {
				node.right = newNode;
			}
			this.fixUpTree(newNode);
		}
	};

	this.remove = function(key) {
		var keyFound = false;
		var rootTemp = this.root;
		while (!keyFound) {
			var compareVal = this.compare(rootTemp.key, key);
			if (compareVal == -1) {
				rootTemp = rootTemp.right;
			} else if (compareVal == 1) {
				rootTemp = rootTemp.left;
			} else {
				keyFound = true;
			}
			;
		}
		this.removeKey(rootTemp);
	};

	/* Tree remove key. */
	this.removeKey = function(key) {
		var rootY = key;
		var bkpYColor = this.getColor(rootY);
		var rootX = key;
		if (this.getParent(key) == null) {
			this.root = null;
		} else if ((this.getLeft(key) == null) && (this.getRight(key) == null)) {
			if (bkpYColor == 'b') {
				this.fixUpDelete(key);
			}
			if (this.getParent(key) != null) {
				if (key == this.getLeft(this.getParent(key))) {
					this.getParent(key).left = null;
				} else if (key == this.getRight(this.getParent(key))) {
					this.getParent(key).right = null;
				}
				key.parent = null;
			}
		} else {
			if (this.getLeft(key) == null) {
				rootX = (this.getRight(key) == null) ? key : this.getRight(key);
				this.transplantNode(key, this.getRight(key));
			} else if (this.getRight(key) == null) {
				rootX = (this.getLeft(key) == null) ? key : this.getLeft(key);
				this.transplantNode(key, this.getLeft(key));
			} else {
				rootY = this.getMinSuccussor(key);
				rootX = this.getRight(rootY);
				bkpYColor = this.getColor(rootY);
				if (key == this.getParent(rootY)) {
					if (rootX != null) {
						rootX.parent = rootY;
					}
				} else {
					this.transplantNode(rootY, this.getRight(rootY));
					this.getRight(rootY).parent = rootY;
					rootY.right = this.getRight(key);
				}
				this.transplantNode(key, rootY);
				this.getLeft(rootY).parent = rootY;
				rootY.left = this.getLeft(key);
				rootY.color = this.getColor(key);
			}
			if (bkpYColor == 'b') {
				this.fixUpDelete(rootX);
			}
		}
		this.size -= 1;
	};

	/* Tree remove values. */
	this.removeValue = function(key, valueToRemove) {
		var keyFound = false;
		var rootTemp = this.root;
		var urlIfRmvKey = "";
		while (!keyFound) {
			var compareVal = this.compare(rootTemp.key, key);
			if (compareVal == -1) {
				rootTemp = rootTemp.right;
			} else if (compareVal == 1) {
				rootTemp = rootTemp.left;
			} else {
				keyFound = true;
			}
			;
		}
		var values = rootTemp.values;
		var index = 0;
		var arrayNew = new Array();
		for ( var i = 0; i < values.length; i++) {
			if (!(values[i] == valueToRemove)) {
				arrayNew[index] = values[i];
				index += 1;
			}
			;
		}
		rootTemp.values = arrayNew;
		if (arrayNew.length == 0) {
			urlIfRmvKey = this.createJSON();
			this.removeKey(rootTemp);
		}
		;
		return urlIfRmvKey;
	};

	/*
	 * Tree iterate : inorder travesal. Avoid unncessery tree iterate if tree is
	 * same. Use treeMap.inorderArray
	 */
	this.iterate = function() {
		var rootTemp = this.root;
		this.inorderArray = this.iterateTree(rootTemp, {});
		return this.inorderArray;
	};

	/* Tree iterate : inorder travesal. */
	this.iterateTree = function(rootTemp, rootArray) {
		if (rootTemp != null) {
			rootArray = this.iterateTree(rootTemp.left, rootArray);
			rootArray[rootTemp.key] = rootTemp.values;
			rootArray = this.iterateTree(rootTemp.right, rootArray);
		}
		return rootArray;
	};

	/* Tree Clear. */
	this.clear = function() {
		this.root = null;
		this.size = 0;
	};

	/* Method : Create JSON value of the tree data. */
	this.createJSON = function() {
		var jsonData = "";
		this.iterate();
		var jsonDataVal = this.convertTreeToString();
		if ("" != jsonDataVal) {
			jsonData += "{";
			jsonData += jsonDataVal;
			jsonData += "}";
		}
		return jsonData;
	};

	/* Method : Build tree from JSON data. */
	this.buildTreeFromJSON = function(jsonData) {
		this.clear();
		var js = new TreeMapJS();
		$.each(JSON.parse(jsonData), function(key, value) {
			for ( var i = 0; i < value.length; i++) {
				js.add(key, value[i]);
			}
		});
		this.root = js.root;
	};

	/*---------- Util Methods ----------*/

	/* Method : Maintain the R-B property after insertion. */
	this.fixUpTree = function(keyNode) {

		while ((keyNode != null) && (this.getParent(keyNode) != null)
				&& ('r' == this.getColor(this.getParent(keyNode)))) {
			if (this.getParent(keyNode) == this.getLeft(this.getParent(this
					.getParent(keyNode)))) {
				var tempRigthNode = this.getRight(this.getParent(this
						.getParent(keyNode)));
				if (this.getColor(tempRigthNode) == 'r') {
					tempRigthNode.color = 'b';
					this.getParent(keyNode).color = 'b';
					this.getParent(this.getParent(keyNode)).color = 'r';
					keyNode = this.getParent(this.getParent(keyNode));
				} else {
					if (keyNode == this.getRight(this.getParent(keyNode))) {
						keyNode = this.getParent(keyNode);
						this.leftFixUp(keyNode);
					}
					if (null != this.getParent(keyNode)) {
						this.getParent(keyNode).color = 'b';
					}
					if (null != this.getParent(this.getParent(keyNode))) {
						this.getParent(this.getParent(keyNode)).color = 'r';
						this
								.rigthFixUp(this.getParent(this
										.getParent(keyNode)));
					}
				}
			} else {
				var tempLeftNode = this.getLeft(this.getParent(this
						.getParent(keyNode)));
				if (this.getColor(tempLeftNode) == 'r') {
					tempLeftNode.color = 'b';
					this.getParent(keyNode).color = 'b';
					this.getParent(this.getParent(keyNode)).color = 'r';
					keyNode = this.getParent(this.getParent(keyNode));
				} else {
					if (keyNode == this.getLeft(this.getParent(keyNode))) {
						keyNode = this.getParent(keyNode);
						this.rigthFixUp(keyNode);
					}
					if (null != this.getParent(keyNode)) {
						this.getParent(keyNode).color = 'b';
					}
					if (null != this.getParent(this.getParent(keyNode))) {
						this.getParent(this.getParent(keyNode)).color = 'r';
						this.leftFixUp(this.getParent(this.getParent(keyNode)));
					}
				}
			}
		}
		this.root.color = 'b';

	};

	/* Method : Maintain the R-B property after deletion. */
	this.fixUpDelete = function(node) {
		while ((node != this.root) && (this.getColor(node) == 'b')) {
			if (node == this.getLeft(this.getParent(node))) {
				var nodeRght = this.getRight(this.getParent(node));
				if (this.getColor(nodeRght) == 'r') {
					this.getParent(node).color = 'r';
					nodeRght.color = 'b';
					this.leftFixUp(this.getParent(node));
					nodeRght = this.getRight(this.getParent(node));
				}
				if ((this.getColor(this.getLeft(nodeRght)) == 'b')
						&& (this.getColor(this.getRight(nodeRght)) == 'b')) {
					node = this.getParent(node);
					nodeRght.color = 'r';
				} else {
					if (this.getColor(this.getRight(nodeRght)) == 'b') {
						nodeRght.color = 'r';
						this.getLeft(nodeRght).color = 'b';
						this.rigthFixUp(nodeRght);
						nodeRght = this.getRight(this.getParent(node));
					}
					nodeRght.color = this.getColor(this.getParent(node));
					this.getParent(node).color = 'b';
					this.getRight(nodeRght).color = 'b';
					this.leftFixUp(this.getParent(node));
					node = this.root;
				}
			} else {
				var nodeLft = this.getLeft(this.getParent(node));
				if (this.getColor(nodeLft) == 'r') {
					nodeLft.color = 'b';
					this.getParent(node).color = 'r';
					this.rigthFixUp(this.getParent(node));
					nodeLft = this.getLeft(this.getParent(node));
				}
				if ((this.getColor(this.getLeft(nodeLft)) == 'b')
						&& (this.getColor(this.getRight(nodeLft)) == 'b')) {
					node = this.getParent(node);
					nodeLft.color = 'r';
				} else {
					if (this.getColor(this.getLeft(nodeLft)) == 'b') {
						nodeLft.color = 'r';
						this.getRight(nodeLft).color = 'b';
						this.leftFixUp(nodeLft);
						nodeLft = this.getLeft(this.getParent(node));
					}
					nodeLft.color = this.getColor(this.getParent(node));
					this.getParent(node).color = 'b';
					this.getLeft(nodeLft).color = 'b';
					this.rigthFixUp(this.getParent(node));
					node = this.root;
				}
			}
		}
		node.color = 'b';
	}

	/* Method : Right Fix Up */
	this.rigthFixUp = function(keyNode) {
		var nodeBkpUp = this.getLeft(keyNode);
		keyNode.left = nodeBkpUp.right;
		if (this.getRight(nodeBkpUp) != null) {
			this.getRight(nodeBkpUp).parent = keyNode;
		}
		nodeBkpUp.parent = this.getParent(keyNode);
		if (this.getParent(keyNode) == null) {
			this.root = nodeBkpUp;
		} else if (keyNode == this.getLeft(this.getParent(keyNode))) {
			this.getParent(keyNode).left = nodeBkpUp;
		} else {
			this.getParent(keyNode).right = nodeBkpUp;
		}
		keyNode.parent = nodeBkpUp;
		nodeBkpUp.right = keyNode;
	};

	/* Method : Left Fix Up */
	this.leftFixUp = function(keyNode) {
		var nodeBkp = this.getRight(keyNode);
		keyNode.right = nodeBkp.left;
		if (nodeBkp.left != null) {
			nodeBkp.left.parent = keyNode;
		}
		nodeBkp.parent = this.getParent(keyNode);
		if (this.getParent(keyNode) == null) {
			this.root = nodeBkp;
		} else if (keyNode == this.getLeft(this.getParent(keyNode))) {
			this.getParent(keyNode).left = nodeBkp;
		} else {
			this.getParent(keyNode).right = nodeBkp;
		}
		keyNode.parent = nodeBkp;
		nodeBkp.left = keyNode;
	};

	/* Method: Get the color of node. */
	this.getColor = function(key) {
		return (key == null) ? 'b' : key.color;
	};

	/* Method: Get the parent of node. */
	this.getParent = function(key) {
		return (key == null) ? null : key.parent;
	};

	/* Method: Get the left node of node. */
	this.getLeft = function(key) {
		return (key == null) ? null : key.left;
	};

	/* Method : Get the right node of the key. */
	this.getRight = function(key) {
		return (key == null) ? null : key.right;
	};

	/* Method : Get the size of the tree. */
	this.getSize = function() {
		return this.size;
	};

	/* Compare two nodes value. */
	this.compare = function(prevKey, currKey) {
		var returnVal = 0; // Default
		var prevKeyIndex = 0;
		var currKeyIndex = 0;
		var toCont = true;
		while ((toCont) && (prevKeyIndex < prevKey.length)
				&& (currKeyIndex < currKey.length)) {
			if (prevKey[prevKeyIndex] < currKey[currKeyIndex]) {
				toCont = false;
				returnVal = -1;
			} else if (prevKey[prevKeyIndex] > currKey[currKeyIndex]) {
				toCont = false;
				returnVal = 1;
			} else {
				prevKeyIndex += 1;
				currKeyIndex += 1;
			}
			;
		}
		if ((returnVal == 0) && (prevKey.length < currKey.length)) {
			returnVal = -1;
		} else if ((returnVal == 0) && (prevKey.length > currKey.length)) {
			returnVal = 1;
		}
		return returnVal;
	};

	/* Convert node to string */
	this.convertTreeToString = function() {
		var treeAsString = "";
		var array = new Array();
		var isFirst = 0;
		for ( var i in this.inorderArray) {
			if (isFirst == 1) {
				treeAsString += ",";
			}
			array = this.inorderArray[i];
			treeAsString += '"' + i + '"';
			treeAsString += ":[";
			if ((!(array === undefined)) && (array.length > 0)) {
				for ( var index = 0; index < array.length; index++) {
					if (index > 0) {
						treeAsString += ",";
					}
					treeAsString += '"' + array[index] + '"';
				}
			}
			treeAsString += "]";
			isFirst = 1;
		}
		return treeAsString;
	};

	/* Method : Get the min successor of a node. */
	this.getMinSuccussor = function(node) {
		if (this.getLeft(node) == null) {
			return node;
		}
		return this.getMinSuccussor(this.getLeft(node));
	};

	/* Method : Get the min successor of a node. */
	this.getSuccussor = function(node) {
		if (this.getRight(node) != null) {
			return this.getMinSuccussor(this.getRight(node));
		}
		var succrRght = this.getParent(node);
		while ((succrRght != null) && (node == this.getRight(succrRght))) {
			node = succrRght;
			succrRght = this.getParent(node);
		}
		return succrRght;
	};

	/* Method : To transplant the nodes after deletion. */
	this.transplantNode = function(nodeFirst, nodeSecond) {
		if (this.root == null) {
			this.root = nodeSecond;
		} else if (this.getRight(this.getParent(nodeFirst)) == nodeFirst) {
			if (this.getParent(nodeFirst) != null) {
				this.getParent(nodeFirst).right = nodeSecond;
			}
		} else {
			if (this.getParent(nodeFirst) != null) {
				this.getParent(nodeFirst).left = nodeSecond;
			}
		}
		if (nodeSecond != null) {
			nodeSecond.parent = nodeFirst.parent;
		}
	};
};