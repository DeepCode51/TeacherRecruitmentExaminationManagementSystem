<template>
  <div class="main-content">
    <!-- 列表页 -->
    <div v-if="showFlag">
      <el-form :inline="true" :model="searchForm" class="form-content">
        <el-row :gutter="20" class="slt" :style="{justifyContent:contents.searchBoxPosition=='1'?'flex-start':contents.searchBoxPosition=='2'?'center':'flex-end'}">
		<el-form-item class="select" label="角色" prop="roleName">
			<el-select v-model="roleName" placeholder="请选择角色">
				<el-option v-for="(item,index) in roleNameList" v-bind:key="index" :label="item"
					:value="item">
				</el-option>
			</el-select>
		</el-form-item>
          <el-form-item>
            <el-button v-if="contents.searchBtnIcon == 1 && contents.searchBtnIconPosition == 1" icon="el-icon-search" type="success" @click="search()">{{ contents.searchBtnFont == 1?'查询':'' }}</el-button>
            <el-button v-if="contents.searchBtnIcon == 1 && contents.searchBtnIconPosition == 2" type="success" @click="search()">{{ contents.searchBtnFont == 1?'查询':'' }}<i class="el-icon-search el-icon--right"/></el-button>
            <el-button v-if="contents.searchBtnIcon == 0" type="success" @click="search()">{{ contents.searchBtnFont == 1?'查询':'' }}</el-button>
          </el-form-item>
        </el-row>
        <el-row class="ad" :style="{justifyContent:contents.btnAdAllBoxPosition=='1'?'flex-start':contents.btnAdAllBoxPosition=='2'?'center':'flex-end'}">
          <el-form-item>


          </el-form-item>
        </el-row>
      </el-form>
      <div class="table-content">
        <el-table class="tables" :size="contents.tableSize" :show-header="contents.tableShowHeader"
            :header-row-style="headerRowStyle" :header-cell-style="headerCellStyle"
            :border="contents.tableBorder"
            :fit="contents.tableFit"
            :stripe="contents.tableStripe"
            :style="{width: '100%',fontSize:contents.tableContentFontSize,color:contents.tableContentFontColor}"
            v-if="isAuth('menu','查看')"
            :data="backChildMenuList"
            v-loading="dataListLoading"
            @selection-change="selectionChangeHandler">
            <el-table-column  v-if="contents.tableSelection"
                type="selection"
                header-align="center"
                align="center"
                width="50">
            </el-table-column>
            <el-table-column label="索引" v-if="contents.tableIndex" type="index" width="50" />
		<el-table-column :sortable="contents.tableSortable" :align="contents.tableAlign"
			prop="parentMenuName" header-align="center" label="一级菜单">
			<template slot-scope="scope">
				{{scope.row.parentMenuName}}
			</template>
		</el-table-column>
		<el-table-column :sortable="contents.tableSortable" :align="contents.tableAlign" prop="menu"
			header-align="center" label="二级菜单">
			<template slot-scope="scope">
				{{scope.row.menu}}
			</template>
		</el-table-column>
            <el-table-column width="300" :align="contents.tableAlign"
                header-align="center"
                label="操作">
                <template slot-scope="scope">
                <el-button v-if="isAuth('menu','修改') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 1" type="primary" icon="el-icon-edit" size="mini" @click="addOrUpdateHandler(scope.row.id)">{{ contents.tableBtnFont == 1?'修改':'' }}</el-button>
                <el-button v-if="isAuth('menu','修改') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 2" type="primary" size="mini" @click="addOrUpdateHandler(scope.row.id)">{{ contents.tableBtnFont == 1?'修改':'' }}<i class="el-icon-edit el-icon--right" /></el-button>
                <el-button v-if="isAuth('menu','修改') && contents.tableBtnIcon == 0" type="primary" size="mini" @click="addOrUpdateHandler(scope.row.id)">{{ contents.tableBtnFont == 1?'修改':'' }}</el-button>




                <el-button v-if="isAuth('menu','编辑名称') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 1" type="primary" icon="el-icon-edit" size="mini" @click="updateMenuNamePage(scope.row)">{{ contents.tableBtnFont == 1?'编辑名称':'' }}</el-button>
                <el-button v-if="isAuth('menu','编辑名称') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 2" type="primary" size="mini" @click="updateMenuNamePage(scope.row)">{{ contents.tableBtnFont == 1?'编辑名称':'' }}<i class="el-icon-edit el-icon--right" /></el-button>
                <el-button v-if="isAuth('menu','编辑名称') && contents.tableBtnIcon == 0" type="primary" size="mini" @click="updateMenuNamePage(scope.row)">{{ contents.tableBtnFont == 1?'编辑名称':'' }}</el-button>
                <el-button v-if="isAuth('menu','编辑父级') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 1" type="primary" icon="el-icon-edit" size="mini" @click="updateMenuLevelPage(scope.row)">{{ contents.tableBtnFont == 1?'编辑父级':'' }}</el-button>
                <el-button v-if="isAuth('menu','编辑父级') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 2" type="primary" size="mini" @click="updateMenuLevelPage(scope.row)">{{ contents.tableBtnFont == 1?'编辑父级':'' }}<i class="el-icon-edit el-icon--right" /></el-button>
                <el-button v-if="isAuth('menu','编辑父级') && contents.tableBtnIcon == 0" type="primary" size="mini" @click="updateMenuLevelPage(scope.row)">{{ contents.tableBtnFont == 1?'编辑父级':'' }}</el-button>
                <el-button v-if="isAuth('menu','删除') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 1" type="danger" icon="el-icon-delete" size="mini" @click="deleteMenu(scope.row)">{{ contents.tableBtnFont == 1?'删除':'' }}</el-button>
                <el-button v-if="isAuth('menu','删除') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 2" type="danger" size="mini" @click="deleteMenu(scope.row)">{{ contents.tableBtnFont == 1?'删除':'' }}<i class="el-icon-delete el-icon--right" /></el-button>
                <el-button v-if="isAuth('menu','删除') && contents.tableBtnIcon == 0" type="danger" size="mini" @click="deleteMenu(scope.row)">{{ contents.tableBtnFont == 1?'删除':'' }}</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-pagination
          clsss="pages"
          :layout="layouts"
          @size-change="sizeChangeHandle"
          @current-change="currentChangeHandle"
          :current-page="pageIndex"
          :page-sizes="[10, 20, 50, 100]"
          :page-size="Number(contents.pageEachNum)"
          :total="totalPage"
          :small="contents.pageStyle"
          class="pagination-content"
          :background="contents.pageBtnBG"
          :style="{textAlign:contents.pagePosition==1?'left':contents.pagePosition==2?'center':'right'}"
        ></el-pagination>
      </div>
    </div>
    <!-- 添加/修改页面  将父组件的search方法传递给子组件-->
    <add-or-update v-if="addOrUpdateFlag" :parent="this" ref="addOrUpdate"></add-or-update>



	<el-dialog title="修改菜单" :visible.sync="updateMenuNameVisiable" width="50%">
		<el-form ref="form" :model="form" label-width="80px">
			<el-form-item label="一级菜单">
				<el-input v-model="checkParentMenuName"></el-input>
			</el-form-item>
			<el-form-item label="二级菜单">
				<el-input v-model="checkChildMenuName"></el-input>
			</el-form-item>
		</el-form>
		<span slot="footer" class="dialog-footer">
			<el-button @click="updateMenuNamePage">取 消</el-button>
			<el-button type="primary" @click="updateMenuName">确 定</el-button>
		</span>
	</el-dialog>

	<el-dialog title="修改菜单" :visible.sync="updateMenuLevelVisiable" width="50%">
		<el-form ref="form" :model="form" label-width="80px">
			<el-form-item label="一级菜单">
				<el-select v-model="checkParentMenuName" placeholder="请选择一级菜单">
					<el-option v-for="(item,index) in parentMenuNameList" v-bind:key="index" :label="item"
						:value="item">
					</el-option>
				</el-select>
			</el-form-item>
		</el-form>
		<span slot="footer" class="dialog-footer">
			<el-button @click="updateMenuLevelPage">取 消</el-button>
			<el-button type="primary" @click="updateMenuLevel">确 定</el-button>
		</span>
	</el-dialog>

  </div>
</template>
<script>
import AddOrUpdate from "./add-or-update";
export default {
  data() {
    return {
      searchForm: {
        key: ""
      },
      form:{},
	checkParentMenuName: '',
	oldCheckParentMenuName: '',
	checkChildMenuName: '',
	oldCheckChildMenuName: '',
	menuList: [],
	roleName: '管理员',
	roleNameList: [],
	backMenuList: [],
	backChildMenuList: [],
	parentMenuNameList: [],
	updateMenuNameVisiable: false,
	updateMenuLevelVisiable: false,
      dataList: [],
      pageIndex: 1,
      pageSize: 10,
      totalPage: 0,
      dataListLoading: false,
      dataListSelections: [],
      showFlag: true,
      sfshVisiable: false,
      shForm: {},
      chartVisiable: false,
      addOrUpdateFlag:false,
      contents:{"searchBtnFontColor":"rgba(255, 255, 255, 1)","pagePosition":"2","inputFontSize":"14px","inputBorderRadius":"20px","tableBtnDelFontColor":"rgba(255, 255, 255, 1)","tableBtnIconPosition":"1","searchBtnHeight":"40px","tableBgColor":"#f5f5f5","inputIconColor":"rgba(255, 255, 255, 1)","searchBtnBorderRadius":"20px","tableStripe":false,"btnAdAllWarnFontColor":"rgba(36, 139, 146, 1)","tableBtnDelBgColor":"rgba(36, 139, 146, 1)","searchBtnIcon":"1","tableSize":"medium","searchBtnBorderStyle":"solid","text":{"padding":"0px","boxShadow":"0px 0px 0px 0px  rgba(142, 209, 214, 1)","margin":"10px auto","borderColor":"rgba(255, 255, 255, 1)","backgroundColor":"rgba(144, 238, 144, 0)","color":"rgba(36, 139, 146, 1)","borderRadius":"0","borderWidth":"0","width":"auto","lineHeight":"200px","fontSize":"30px","borderStyle":"double"},"tableSelection":true,"searchBtnBorderWidth":"5px","tableContentFontSize":"14px","searchBtnBgColor":"rgba(36, 139, 146, 1)","inputTitleSize":"14px","btnAdAllBorderColor":"#DCDFE6","pageJumper":false,"btnAdAllIconPosition":"1","searchBoxPosition":"2","tableBtnDetailFontColor":"rgba(255, 255, 255, 1)","tableBtnHeight":"35px","pagePager":true,"searchBtnBorderColor":"rgba(220, 223, 230, 1)","tableHeaderFontColor":"rgba(0, 0, 0, 1)","inputTitle":"1","tableBtnBorderRadius":"10px 0px 10px 0px","btnAdAllFont":"1","btnAdAllDelFontColor":"rgba(36, 139, 146, 1)","tableBtnIcon":"0","btnAdAllHeight":"40px","btnAdAllWarnBgColor":"rgba(36, 139, 146, 0)","btnAdAllBorderWidth":"0","tableStripeFontColor":"rgba(0, 0, 0, 1)","tableBtnBorderStyle":"solid","inputHeight":"40px","btnAdAllBorderRadius":"0","btnAdAllDelBgColor":"rgba(36, 139, 146, 0)","pagePrevNext":true,"btnAdAllAddBgColor":"rgba(36, 139, 146, 0)","searchBtnFont":"1","tableIndex":true,"btnAdAllIcon":"1","tableSortable":false,"pageSizes":false,"tableFit":true,"pageBtnBG":false,"searchBtnFontSize":"14px","tableBtnEditBgColor":"rgba(36, 139, 146, 1)","box":{"padding":"10px 20px","boxShadow":"0 0 6px rgba(0,0,0,0)","flag":"1","backgroundImage":"http://codegen.caihongy.cn/20211124/873782b96c3543ceb98920965ce530c9.jpg","background":"rgba(142, 209, 214, 0.4)"},"inputBorderWidth":"5px","inputFontPosition":"1","inputFontColor":"rgba(255, 255, 255, 1)","pageEachNum":10,"tableHeaderBgColor":"rgba(142, 209, 214, 1)","inputTitleColor":"rgba(0, 0, 0, 1)","btnAdAllBoxPosition":"1","tableBtnDetailBgColor":"rgba(36, 139, 146, 1)","inputIcon":"0","searchBtnIconPosition":"1","btnAdAllFontSize":"16px","inputBorderStyle":"solid","tableHoverFontColor":"#333","inputBgColor":"rgba(36, 139, 146, 1)","pageStyle":true,"pageTotal":false,"btnAdAllAddFontColor":"rgba(36, 139, 146, 1)","tableBtnFont":"1","tableContentFontColor":"rgba(0, 1, 2, 1)","inputBorderColor":"rgba(220, 223, 230, 1)","tableShowHeader":true,"tableHoverBgColor":"rgba(142, 209, 214, 0.5)","tableBtnFontSize":"14px","tableBtnBorderColor":"rgba(220, 223, 230, 1)","inputIconPosition":"2","tableBorder":true,"btnAdAllBorderStyle":"solid","tableBtnBorderWidth":"3px","tableStripeBgColor":"#F5F7FA","tableBtnEditFontColor":"rgba(255, 255, 255, 1)","tableAlign":"left"},
      layouts: '',


    };
  },
  created() {
    this.init();
    this.getDataList();
    this.contentStyleChange()
  },
  mounted() {

  },
  filters: {
    htmlfilter: function (val) {
      return val.replace(/<[^>]*>/g).replace(/undefined/g,'');
    }
  },
  components: {
    AddOrUpdate,
  },
  methods: {
	// 修改菜单名称页面
	updateMenuNamePage(row) {
		this.updateMenuNameVisiable = !this.updateMenuNameVisiable;
		if (row) {
			this.checkParentMenuName = row.parentMenuName;
			this.oldCheckParentMenuName = row.parentMenuName;
			this.checkChildMenuName = row.menu;
			this.oldCheckChildMenuName = row.menu;
		}
	},
	// 修改菜单名称
	updateMenuName() {
		for (var i in this.menuList) {
			if (this.menuList[i].roleName == this.roleName) {
				let oldBackMenuList = this.menuList[i].backMenu;
				let parentMenuName = '';
				let childMenuList = [];
				for (var j in oldBackMenuList) {
					parentMenuName = oldBackMenuList[j].menu;
					childMenuList = oldBackMenuList[j].child;
					if (this.oldCheckParentMenuName == parentMenuName) {
						if (parentMenuName != this.checkParentMenuName) {
							//修改一级菜单名字
							oldBackMenuList[j].menu = this.checkParentMenuName;
						}
						for (var k in childMenuList) {
							if (this.oldCheckChildMenuName == childMenuList[k].menu) {
								if (this.checkChildMenuName != childMenuList[k].menu) {
									//修改二级菜单名字
									childMenuList[k].menu = this.checkChildMenuName;
									childMenuList[k].parentMenuName = this.checkParentMenuName;
								}
							}
						}
					}
				}
			}
		}
		this.$http({
			url: "menu/update",
			method: "post",
			data: {
				"id": 1,
				"menujson": JSON.stringify(this.menuList)
			}
		}).then(({
			data
		}) => {
			if (data && data.code === 0) {
				this.$message({
					message: "操作成功",
					type: "success",
					duration: 1500,
					onClose: () => {
						this.getDataList(this.roleName);
						this.updateMenuNamePage();
					}
				});
			} else {
				this.$message.error(data.msg);
			}
		});
	},
	// 修改一级菜单页面
	updateMenuLevelPage(row) {
		this.updateMenuLevelVisiable = !this.updateMenuLevelVisiable;
		if (row) {
			this.checkParentMenuName = row.parentMenuName;
			this.oldCheckParentMenuName = row.parentMenuName;
			this.checkChildMenuName = row.menu;
		}
	},
	// 修改一级菜单
	updateMenuLevel() {
		for (var i in this.menuList) {
			if (this.menuList[i].roleName == this.roleName) {
				debugger
				let oldBackMenuList = this.menuList[i].backMenu;
				let parentMenuName = '';
				let childMenuList = [];
				for (var j in oldBackMenuList) {
					parentMenuName = oldBackMenuList[j].menu;
					childMenuList = oldBackMenuList[j].child;
					if (this.oldCheckParentMenuName == parentMenuName) {
						//获取原父级菜单下的子菜单
						if (parentMenuName != this.checkParentMenuName) {
							let fromChildMenu;
							for (var k in childMenuList) {
								if (this.checkChildMenuName == childMenuList[k].menu) {
									fromChildMenu = childMenuList[k];
									let toChildMenuList = [];
									for (var l in oldBackMenuList) {
										if (this.checkParentMenuName == oldBackMenuList[l].menu) {
											toChildMenuList = oldBackMenuList[l].child;
											toChildMenuList.push(fromChildMenu);
											break;
										}
									}
									childMenuList.splice(k, 1)
									break;
								}
							}
						}
						break;
					}
				}
			}
		}
		this.$http({
			url: "menu/update",
			method: "post",
			data: {
				"id": 1,
				"menujson": JSON.stringify(this.menuList)
			}
		}).then(({
			data
		}) => {
			if (data && data.code === 0) {
				this.$message({
					message: "操作成功",
					type: "success",
					duration: 1500,
					onClose: () => {
						this.getDataList(this.roleName);
						this.updateMenuLevelPage();
					}
				});
			} else {
				this.$message.error(data.msg);
			}
		});
	},
    contentStyleChange() {
      this.contentSearchStyleChange()
      this.contentBtnAdAllStyleChange()
      this.contentSearchBtnStyleChange()
      this.contentTableBtnStyleChange()
      this.contentPageStyleChange()
    },
    contentSearchStyleChange() {
      this.$nextTick(()=>{
        document.querySelectorAll('.form-content .slt .el-input__inner').forEach(el=>{
          let textAlign = 'left'
          if(this.contents.inputFontPosition == 2) textAlign = 'center'
          if(this.contents.inputFontPosition == 3) textAlign = 'right'
          el.style.textAlign = textAlign
          el.style.height = this.contents.inputHeight
          el.style.lineHeight = this.contents.inputHeight
          el.style.color = this.contents.inputFontColor
          el.style.fontSize = this.contents.inputFontSize
          el.style.borderWidth = this.contents.inputBorderWidth
          el.style.borderStyle = this.contents.inputBorderStyle
          el.style.borderColor = this.contents.inputBorderColor
          el.style.borderRadius = this.contents.inputBorderRadius
          el.style.backgroundColor = this.contents.inputBgColor
        })
        if(this.contents.inputTitle) {
          document.querySelectorAll('.form-content .slt .el-form-item__label').forEach(el=>{
            el.style.color = this.contents.inputTitleColor
            el.style.fontSize = this.contents.inputTitleSize
            el.style.lineHeight = this.contents.inputHeight
          })
        }
        setTimeout(()=>{
          document.querySelectorAll('.form-content .slt .el-input__prefix').forEach(el=>{
            el.style.color = this.contents.inputIconColor
            el.style.lineHeight = this.contents.inputHeight
          })
          document.querySelectorAll('.form-content .slt .el-input__suffix').forEach(el=>{
            el.style.color = this.contents.inputIconColor
            el.style.lineHeight = this.contents.inputHeight
          })
          document.querySelectorAll('.form-content .slt .el-input__icon').forEach(el=>{
            el.style.lineHeight = this.contents.inputHeight
          })
        },10)

      })
    },
    // 搜索按钮
    contentSearchBtnStyleChange() {
      this.$nextTick(()=>{
        document.querySelectorAll('.form-content .slt .el-button--success').forEach(el=>{
          el.style.height = this.contents.searchBtnHeight
          el.style.color = this.contents.searchBtnFontColor
          el.style.fontSize = this.contents.searchBtnFontSize
          el.style.borderWidth = this.contents.searchBtnBorderWidth
          el.style.borderStyle = this.contents.searchBtnBorderStyle
          el.style.borderColor = this.contents.searchBtnBorderColor
          el.style.borderRadius = this.contents.searchBtnBorderRadius
          el.style.backgroundColor = this.contents.searchBtnBgColor
        })
      })
    },
    // 新增、批量删除
    contentBtnAdAllStyleChange() {
      this.$nextTick(()=>{
        document.querySelectorAll('.form-content .ad .el-button--success').forEach(el=>{
          el.style.height = this.contents.btnAdAllHeight
          el.style.color = this.contents.btnAdAllAddFontColor
          el.style.fontSize = this.contents.btnAdAllFontSize
          el.style.borderWidth = this.contents.btnAdAllBorderWidth
          el.style.borderStyle = this.contents.btnAdAllBorderStyle
          el.style.borderColor = this.contents.btnAdAllBorderColor
          el.style.borderRadius = this.contents.btnAdAllBorderRadius
          el.style.backgroundColor = this.contents.btnAdAllAddBgColor
        })
        document.querySelectorAll('.form-content .ad .el-button--danger').forEach(el=>{
          el.style.height = this.contents.btnAdAllHeight
          el.style.color = this.contents.btnAdAllDelFontColor
          el.style.fontSize = this.contents.btnAdAllFontSize
          el.style.borderWidth = this.contents.btnAdAllBorderWidth
          el.style.borderStyle = this.contents.btnAdAllBorderStyle
          el.style.borderColor = this.contents.btnAdAllBorderColor
          el.style.borderRadius = this.contents.btnAdAllBorderRadius
          el.style.backgroundColor = this.contents.btnAdAllDelBgColor
        })
        document.querySelectorAll('.form-content .ad .el-button--warning').forEach(el=>{
          el.style.height = this.contents.btnAdAllHeight
          el.style.color = this.contents.btnAdAllWarnFontColor
          el.style.fontSize = this.contents.btnAdAllFontSize
          el.style.borderWidth = this.contents.btnAdAllBorderWidth
          el.style.borderStyle = this.contents.btnAdAllBorderStyle
          el.style.borderColor = this.contents.btnAdAllBorderColor
          el.style.borderRadius = this.contents.btnAdAllBorderRadius
          el.style.backgroundColor = this.contents.btnAdAllWarnBgColor
        })
      })
    },
    // 表格
    // rowStyle({ row, rowIndex}) {
    //   if (rowIndex % 2 == 1) {
    //     if(this.contents.tableStripe) {
    //       return {color:this.contents.tableStripeFontColor}
    //     }
    //   } else {
    //     return ''
    //   }
    // },
    // cellStyle({ row, rowIndex}){
    //   if (rowIndex % 2 == 1) {
    //     if(this.contents.tableStripe) {
    //       return {backgroundColor:this.contents.tableStripeBgColor}
    //     }
    //   } else {
    //     return ''
    //   }
    // },
    headerRowStyle({ row, rowIndex}){
      return {color: this.contents.tableHeaderFontColor}
    },
    headerCellStyle({ row, rowIndex}){
      return {backgroundColor: this.contents.tableHeaderBgColor}
    },
    // 表格按钮
    contentTableBtnStyleChange(){
      // this.$nextTick(()=>{
      //   setTimeout(()=>{
      //     document.querySelectorAll('.table-content .tables .el-table__body .el-button--success').forEach(el=>{
      //       el.style.height = this.contents.tableBtnHeight
      //       el.style.color = this.contents.tableBtnDetailFontColor
      //       el.style.fontSize = this.contents.tableBtnFontSize
      //       el.style.borderWidth = this.contents.tableBtnBorderWidth
      //       el.style.borderStyle = this.contents.tableBtnBorderStyle
      //       el.style.borderColor = this.contents.tableBtnBorderColor
      //       el.style.borderRadius = this.contents.tableBtnBorderRadius
      //       el.style.backgroundColor = this.contents.tableBtnDetailBgColor
      //     })
      //     document.querySelectorAll('.table-content .tables .el-table__body .el-button--primary').forEach(el=>{
      //       el.style.height = this.contents.tableBtnHeight
      //       el.style.color = this.contents.tableBtnEditFontColor
      //       el.style.fontSize = this.contents.tableBtnFontSize
      //       el.style.borderWidth = this.contents.tableBtnBorderWidth
      //       el.style.borderStyle = this.contents.tableBtnBorderStyle
      //       el.style.borderColor = this.contents.tableBtnBorderColor
      //       el.style.borderRadius = this.contents.tableBtnBorderRadius
      //       el.style.backgroundColor = this.contents.tableBtnEditBgColor
      //     })
      //     document.querySelectorAll('.table-content .tables .el-table__body .el-button--danger').forEach(el=>{
      //       el.style.height = this.contents.tableBtnHeight
      //       el.style.color = this.contents.tableBtnDelFontColor
      //       el.style.fontSize = this.contents.tableBtnFontSize
      //       el.style.borderWidth = this.contents.tableBtnBorderWidth
      //       el.style.borderStyle = this.contents.tableBtnBorderStyle
      //       el.style.borderColor = this.contents.tableBtnBorderColor
      //       el.style.borderRadius = this.contents.tableBtnBorderRadius
      //       el.style.backgroundColor = this.contents.tableBtnDelBgColor
      //     })

      //   }, 50)
      // })
    },
    // 分页
    contentPageStyleChange(){
      let arr = []

      if(this.contents.pageTotal) arr.push('total')
      if(this.contents.pageSizes) arr.push('sizes')
      if(this.contents.pagePrevNext){
        arr.push('prev')
        if(this.contents.pagePager) arr.push('pager')
        arr.push('next')
      }
      if(this.contents.pageJumper) arr.push('jumper')
      this.layouts = arr.join()
      this.contents.pageEachNum = 10
    },

    init () {
    },
    search() {
      this.pageIndex = 1;
      this.getDataList(this.roleName);
    },

	// 获取菜单列表
	getDataList(rn) {
		if (rn == null) rn = "管理员";
		this.roleNameList = [];
		this.parentMenuNameList = [];
		this.backChildMenuList = [];
		this.dataListLoading = true;
		let params = {
			page: this.pageIndex,
			limit: this.pageSize,
			sort: 'id',
		}
		this.$http({
			url: "menu/page",
			method: "get",
			params: params
		}).then(({
			data
		}) => {
			if (data && data.code === 0) {
				this.dataList = data.data.list;
				this.menuList = eval('(' + data.data.list[0].menujson + ')');
				for (var i in this.menuList) {
					this.roleNameList.push(this.menuList[i].roleName);
					if (this.menuList[i].roleName == rn) {
						this.backMenuList = this.menuList[i].backMenu;
						let parentMenuName = '';
						let childMenuList = [];
						for (var j in this.backMenuList) {
							this.parentMenuNameList.push(this.backMenuList[j].menu);
							parentMenuName = this.backMenuList[j].menu;
							childMenuList = this.backMenuList[j].child;
							// console.log(parentMenuName);
							// console.log(childMenuList);
							if (childMenuList.length > 0) {
								for (var k in childMenuList) {
									childMenuList[k].parentMenuName = parentMenuName;
									this.backChildMenuList.push(childMenuList[k]);
								}
							} else {
								let parentNode = {};
								parentNode.parentMenuName = parentMenuName;
								this.backChildMenuList.push(parentNode);
							}

						}
					}
				}
				this.totalPage = data.data.total;
			} else {
				this.dataList = [];
				this.totalPage = 0;
			}
			console.log(this.roleNameList)
			// console.log(this.backChildMenuList)
			console.log(this.parentMenuNameList);
			this.dataListLoading = false;
		});
	},
    // 每页数
    sizeChangeHandle(val) {
      this.pageSize = val;
      this.pageIndex = 1;
      this.getDataList();
    },
    // 当前页
    currentChangeHandle(val) {
      this.pageIndex = val;
      this.getDataList();
    },
    // 多选
    selectionChangeHandler(val) {
      this.dataListSelections = val;
    },
    // 添加/修改
    addOrUpdateHandler(id,type) {
      this.showFlag = false;
      this.addOrUpdateFlag = true;
      this.crossAddOrUpdateFlag = false;
      if(type!='info'){
        type = 'else';
      }
      this.$nextTick(() => {
        this.$refs.addOrUpdate.init(id,type);
      });
    },
    // 查看评论
    // 下载
    download(file){
      window.open(`${file}`)
    },
	// 删除
	deleteMenu(row) {
		this.$confirm(`确定进行删除操作?`, "提示", {
			confirmButtonText: "确定",
			cancelButtonText: "取消",
			type: "warning"
		}).then(() => {
			debugger
			if (row) {
				this.checkParentMenuName = row.parentMenuName;
				let delFlag = false;
				for (var i in this.menuList) {
					if (this.menuList[i].roleName == this.roleName) {
						let oldBackMenuList = this.menuList[i].backMenu;
						let parentMenuName = '';
						let childMenuList = [];
						for (var j in oldBackMenuList) {
							parentMenuName = oldBackMenuList[j].menu;
							childMenuList = oldBackMenuList[j].child;
							if (this.checkParentMenuName == parentMenuName) {
								if(childMenuList.length>0) {
									this.$message.error("存在二级菜单，无法删除。");
									break;
								}
								oldBackMenuList.splice(j, 1)
								delFlag = true;
								break;
							}
						}
						break;
					}
				}
				if(delFlag) {
					this.$http({
						url: "menu/update",
						method: "post",
						data: {
							"id": 1,
							"menujson": JSON.stringify(this.menuList)
						}
					}).then(({
						data
					}) => {
						if (data && data.code === 0) {
							this.$message({
								message: "操作成功",
								type: "success",
								duration: 1500,
								onClose: () => {
									this.getDataList(this.roleName);
								}
							});
						} else {
							this.$message.error(data.msg);
						}
					});
				}
			}
		})
	},
  }

};
</script>
<style lang="scss" scoped>
  .slt {
    margin: 0 !important;
    display: flex;
  }

  .ad {
    margin: 0 !important;
    display: flex;
  }

  .pages {
    & /deep/ el-pagination__sizes{
      & /deep/ el-input__inner {
        height: 22px;
        line-height: 22px;
      }
    }
  }
  

  .el-button+.el-button {
    margin:0;
  } 

  .tables {
	& /deep/ .el-button--success {
		height: 35px;
		color: rgba(255, 255, 255, 1);
		font-size: 14px;
		border-width: 3px;
		border-style: solid;
		border-color: rgba(220, 223, 230, 1);
		border-radius: 10px 0px 10px 0px;
		background-color: rgba(36, 139, 146, 1);
	}
	
	& /deep/ .el-button--primary {
		height: 35px;
		color: rgba(255, 255, 255, 1);
		font-size: 14px;
		border-width: 3px;
		border-style: solid;
		border-color: rgba(220, 223, 230, 1);
		border-radius: 10px 0px 10px 0px;
		background-color: rgba(36, 139, 146, 1);
	}
	
	& /deep/ .el-button--danger {
		height: 35px;
		color: rgba(255, 255, 255, 1);
		font-size: 14px;
		border-width: 3px;
		border-style: solid;
		border-color: rgba(220, 223, 230, 1);
		border-radius: 10px 0px 10px 0px;
		background-color: rgba(36, 139, 146, 1);
	}

    & /deep/ .el-button {
      margin: 4px;
    }
  }
	.form-content {
		background: transparent;
	}
	.table-content {
		background: transparent;
	}
	
	.tables /deep/ .el-table__body tr {
				background-color: #f5f5f5 !important;
				color: rgba(0, 1, 2, 1) !important;
	 }
	.tables /deep/ .el-table__body tr.el-table__row--striped td {
	    background: transparent;
	}
	.tables /deep/ .el-table__body tr.el-table__row--striped {
		background-color: #F5F7FA !important;
		color: rgba(0, 0, 0, 1) !important;
	}
	
	 .tables /deep/ .el-table__body tr:hover>td {
	   	   background-color: rgba(142, 209, 214, 0.5) !important;
	   	   	   color: #333 !important;
	   	 }
	 
</style>
