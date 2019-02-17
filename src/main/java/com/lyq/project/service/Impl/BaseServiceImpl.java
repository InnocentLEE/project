package com.lyq.project.service.Impl;

import com.alibaba.fastjson.JSON;
import com.lyq.project.common.LYQRequest;
import com.lyq.project.common.LYQResponse;
import com.lyq.project.dao.ContactsMapper;
import com.lyq.project.dto.LoginDto;
import com.lyq.project.dto.MenudTO;
import com.lyq.project.dto.UserInfoDto;
import com.lyq.project.pojo.Contacts;
import com.lyq.project.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service("iBaseService")
public class BaseServiceImpl implements IBaseService {
    @Autowired
    private ContactsMapper contactsMapper;

    @Override
    public LYQResponse login(HttpSession session, LYQRequest<LoginDto> request){
        Contacts contacts = contactsMapper.selectByCardNoAndPassword(request.getBody().getAccountName(),request.getBody().getPassword());
        if(contacts == null){
            return LYQResponse.createByErrorMessage("登录失败");
        }else {
            UserInfoDto userInfoDto = new UserInfoDto();
            userInfoDto.setId(contacts.getId());
            userInfoDto.setUserName(contacts.getContactName());
            userInfoDto.setAccountId(contacts.getId());
            userInfoDto.setAccountName(contacts.getCardno());
            userInfoDto.setSysId("60190fc4-5103-4c76-94e4-12a54b62c92a");
            userInfoDto.setRoleCode(contacts.getOrgtype().toString());
            session.removeAttribute("current_user");
            session.setAttribute("current_user", JSON.toJSONString(userInfoDto));
            return LYQResponse.createBySuccess(session.getId());
        }
    }


    @Override
    public LYQResponse getMenu(int type){
        // region 角色菜单说明
        /*
        * 角色类型：平台管理员0，省级监管部门1、市级监管部门2、客运站3、客运企业4、客运车队5
        *   基础档案：012345
                监管部门信息01
                    省级0
                    市级01
                客运站信息012
                客运企业信息0123
                客运车队信息0123
                客车信息012345
                服务区信息012345
            班次管理：012345
                班车查询012345
                包车查询012345
                路线管理03
                客运排班03
                客车班次查询0345
            售票统计：0345
                03月度路线售票率（某条路线的售票率（售出票数/总票数）方式折线图）
                03年度路线售票率（某条路线的售票率（售出票数/总票数）方式列表）
                03购票方式饼图
                0345客车出勤统计（客车出勤次数柱状图，只统计直属客车）
        *
        */
        // endregion
        LYQResponse response = null;
        switch (type){
            case 0:{
                // region 平台管理员的菜单
                // region 基础档案
                // region 监管部门信息
                // region 省级监管部门
                MenudTO shengji = new MenudTO();
                shengji.setId("c419ee72-f1a9-42b6-9041-80ccd8e40a1b");
                shengji.setTitle("省级");
                shengji.setUrl("/Modules/JiChuDangAn/ShengJiJianGuanBuMen/List.html");
                shengji.setIcon("glyphicon glyphicon-list-alt");
                List<MenudTO> shengjiSub = new ArrayList<>();
                List<MenudTO> shengjiExt = new ArrayList<>();
                shengji.setSubMenu(shengjiSub);
                shengji.setExtends(shengjiExt);
                shengji.setIsEnabled("True");
                shengji.setCode("003300210014");
                // endregion
                // region 市级监管部门
                MenudTO shiji = new MenudTO();
                shiji.setId("c419ee72-f1a9-42b6-9041-80ccd8e40a1b");
                shiji.setTitle("市级");
                shiji.setUrl("/Modules/JiChuDangAn/ShiJiJianGuanBuMen/List.html");
                shiji.setIcon("glyphicon glyphicon-list-alt");
                List<MenudTO> shijiSub = new ArrayList<>();
                List<MenudTO> shijiExt = new ArrayList<>();
                shiji.setSubMenu(shijiSub);
                shiji.setExtends(shijiExt);
                shiji.setIsEnabled("True");
                shiji.setCode("003300210014");
                // endregion

                MenudTO jianguanbumen = new MenudTO();
                jianguanbumen.setId("c419ee72-f1a9-42b6-9041-80ccd8e40a1b");
                jianguanbumen.setTitle("监管部门信息");
                jianguanbumen.setUrl("/");
                jianguanbumen.setIcon("glyphicon glyphicon-list-alt");
                List<MenudTO> jianguanbumenSub = new ArrayList<>();
                List<MenudTO> jianguanbumenExt = new ArrayList<>();
                jianguanbumenSub.add(shengji);
                jianguanbumenSub.add(shiji);
                jianguanbumen.setSubMenu(jianguanbumenSub);
                jianguanbumen.setExtends(jianguanbumenExt);
                jianguanbumen.setIsEnabled("True");
                jianguanbumen.setCode("003300210014");
                // endregion
                // region 客运站信息
                MenudTO keyunzhan = new MenudTO();
                keyunzhan.setId("c419ee72-f1a9-42b6-9041-80ccd8e40a1b");
                keyunzhan.setTitle("客运站信息");
                keyunzhan.setUrl("/Modules/JiChuDangAn/KeYunZhanXinXi/List.html");
                keyunzhan.setIcon("glyphicon glyphicon-list-alt");
                List<MenudTO> keyunzhanSub = new ArrayList<>();
                List<MenudTO> keyunzhanExt = new ArrayList<>();
                keyunzhan.setSubMenu(keyunzhanSub);
                keyunzhan.setExtends(keyunzhanExt);
                keyunzhan.setIsEnabled("True");
                keyunzhan.setCode("003300210014");
                // endregion
                // region 客运企业信息
                MenudTO keyunqiye = new MenudTO();
                keyunqiye.setId("c419ee72-f1a9-42b6-9041-80ccd8e40a1b");
                keyunqiye.setTitle("客运企业信息");
                keyunqiye.setUrl("/Modules/JiChuDangAn/KeYunQiYeXinXi/List.html");
                keyunqiye.setIcon("glyphicon glyphicon-list-alt");
                List<MenudTO> keyunqiyeSub = new ArrayList<>();
                List<MenudTO> keyunqiyeExt = new ArrayList<>();
                keyunqiye.setSubMenu(keyunqiyeSub);
                keyunqiye.setExtends(keyunqiyeExt);
                keyunqiye.setIsEnabled("True");
                keyunqiye.setCode("003300210014");
                // endregion
                // region 客运车队信息
                MenudTO keyunchedui = new MenudTO();
                keyunchedui.setId("c419ee72-f1a9-42b6-9041-80ccd8e40a1b");
                keyunchedui.setTitle("客运车队信息");
                keyunchedui.setUrl("/Modules/JiChuDangAn/KeYunCheDuiXinXi/List.html");
                keyunchedui.setIcon("glyphicon glyphicon-list-alt");
                List<MenudTO> keyuncheduiSub = new ArrayList<>();
                List<MenudTO> keyuncheduiExt = new ArrayList<>();
                keyunchedui.setSubMenu(keyuncheduiSub);
                keyunchedui.setExtends(keyuncheduiExt);
                keyunchedui.setIsEnabled("True");
                keyunchedui.setCode("003300210014");
                // endregion
                // region 客车信息
                MenudTO keche = new MenudTO();
                keche.setId("c419ee72-f1a9-42b6-9041-80ccd8e40a1b");
                keche.setTitle("客车信息");
                keche.setUrl("/Modules/JiChuDangAn/KeCheXinXi/List.html");
                keche.setIcon("glyphicon glyphicon-list-alt");
                List<MenudTO> kecheSub = new ArrayList<>();
                List<MenudTO> kecheExt = new ArrayList<>();
                keche.setSubMenu(kecheSub);
                keche.setExtends(kecheExt);
                keche.setIsEnabled("True");
                keche.setCode("003300210014");
                // endregion
                // region 服务区信息
                MenudTO fuwuqu = new MenudTO();
                fuwuqu.setId("c419ee72-f1a9-42b6-9041-80ccd8e40a1b");
                fuwuqu.setTitle("服务区信息");
                fuwuqu.setUrl("/Modules/JiChuDangAn/FuWuQuXinXi/List.html");
                fuwuqu.setIcon("glyphicon glyphicon-list-alt");
                List<MenudTO> fuwuquSub = new ArrayList<>();
                List<MenudTO> fuwuquExt = new ArrayList<>();
                fuwuqu.setSubMenu(fuwuquSub);
                fuwuqu.setExtends(fuwuquExt);
                fuwuqu.setIsEnabled("True");
                fuwuqu.setCode("003300210014");
                // endregion
                MenudTO jichudangan = new MenudTO();
                jichudangan.setId("d8fba846-971f-4f80-8dd4-da0213390416");
                jichudangan.setTitle("基础档案");
                jichudangan.setUrl("/");
                jichudangan.setIcon("glyphicon glyphicon-list-alt");
                List<MenudTO> jichudanganSub = new ArrayList<>();
                jichudanganSub.add(jianguanbumen);
                jichudanganSub.add(keyunzhan);
                jichudanganSub.add(keyunqiye);
                jichudanganSub.add(keyunchedui);
                jichudanganSub.add(keche);
                jichudanganSub.add(fuwuqu);
                List<MenudTO> jichudanganExt = new ArrayList<>();
                jichudangan.setSubMenu(jichudanganSub);
                jichudangan.setExtends(jichudanganExt);
                jichudangan.setIsEnabled("True");
                jichudangan.setCode("003300210013");
                // endregion
                // region 班次管理
                // region 班车查询
                MenudTO banchechaxun = new MenudTO();
                banchechaxun.setId("c419ee72-f1a9-42b6-9041-80ccd8e40a1b");
                banchechaxun.setTitle("班车查询");
                banchechaxun.setUrl("/Modules/BanCiGuanLi/BanCheChaXun/List.html");
                banchechaxun.setIcon("glyphicon glyphicon-list-alt");
                List<MenudTO> banchechaxunSub = new ArrayList<>();
                List<MenudTO> banchechaxunExt = new ArrayList<>();
                banchechaxun.setSubMenu(banchechaxunSub);
                banchechaxun.setExtends(banchechaxunExt);
                banchechaxun.setIsEnabled("True");
                banchechaxun.setCode("003300210014");
                // endregion
                // region 包车查询
                MenudTO baochechaxun = new MenudTO();
                baochechaxun.setId("c419ee72-f1a9-42b6-9041-80ccd8e40a1b");
                baochechaxun.setTitle("包车查询");
                baochechaxun.setUrl("/Modules/BanCiGuanLi/BaoCheChaXun/List.html");
                baochechaxun.setIcon("glyphicon glyphicon-list-alt");
                List<MenudTO> baochechaxunSub = new ArrayList<>();
                List<MenudTO> baochechaxunExt = new ArrayList<>();
                baochechaxun.setSubMenu(baochechaxunSub);
                baochechaxun.setExtends(baochechaxunExt);
                baochechaxun.setIsEnabled("True");
                baochechaxun.setCode("003300210014");
                // endregion
                // region 路线管理
                MenudTO luxianguanli = new MenudTO();
                luxianguanli.setId("c419ee72-f1a9-42b6-9041-80ccd8e40a1b");
                luxianguanli.setTitle("路线管理");
                luxianguanli.setUrl("/Modules/BanCiGuanLi/LuXianGuanLi/List.html");
                luxianguanli.setIcon("glyphicon glyphicon-list-alt");
                List<MenudTO> luxianguanliSub = new ArrayList<>();
                List<MenudTO> luxianguanliExt = new ArrayList<>();
                luxianguanli.setSubMenu(luxianguanliSub);
                luxianguanli.setExtends(luxianguanliExt);
                luxianguanli.setIsEnabled("True");
                luxianguanli.setCode("003300210014");
                // endregion
                // region 客运排班
                MenudTO keyunpaiban = new MenudTO();
                keyunpaiban.setId("c419ee72-f1a9-42b6-9041-80ccd8e40a1b");
                keyunpaiban.setTitle("客运排班");
                keyunpaiban.setUrl("/Modules/BanCiGuanLi/KeYunPaiBan/List.html");
                keyunpaiban.setIcon("glyphicon glyphicon-list-alt");
                List<MenudTO> keyunpaibanSub = new ArrayList<>();
                List<MenudTO> keyunpaibanExt = new ArrayList<>();
                keyunpaiban.setSubMenu(keyunpaibanSub);
                keyunpaiban.setExtends(keyunpaibanExt);
                keyunpaiban.setIsEnabled("True");
                keyunpaiban.setCode("003300210014");
                // endregion
                // region 客车班次查询
                MenudTO kechebancichaxun = new MenudTO();
                kechebancichaxun.setId("c419ee72-f1a9-42b6-9041-80ccd8e40a1b");
                kechebancichaxun.setTitle("客车班次查询");
                kechebancichaxun.setUrl("/Modules/BanCiGuanLi/KeCheBanCi/List.html");
                kechebancichaxun.setIcon("glyphicon glyphicon-list-alt");
                List<MenudTO> kechebancichaxunSub = new ArrayList<>();
                List<MenudTO> kechebancichaxunExt = new ArrayList<>();
                kechebancichaxun.setSubMenu(kechebancichaxunSub);
                kechebancichaxun.setExtends(kechebancichaxunExt);
                kechebancichaxun.setIsEnabled("True");
                kechebancichaxun.setCode("003300210014");
                // endregion
                MenudTO banciguanli = new MenudTO();
                banciguanli.setId("c419ee72-f1a9-42b6-9041-80ccd8e40a1b");
                banciguanli.setTitle("班次管理");
                banciguanli.setUrl("/");
                banciguanli.setIcon("glyphicon glyphicon-list-alt");
                List<MenudTO> banciguanliSub = new ArrayList<>();
                List<MenudTO> banciguanliExt = new ArrayList<>();
                banciguanliSub.add(banchechaxun);
                banciguanliSub.add(baochechaxun);
                banciguanliSub.add(luxianguanli);
                banciguanliSub.add(keyunpaiban);
                banciguanliSub.add(kechebancichaxun);
                banciguanli.setSubMenu(banciguanliSub);
                banciguanli.setExtends(banciguanliExt);
                banciguanli.setIsEnabled("True");
                banciguanli.setCode("003300210014");
                // endregion
                // region 售票统计
                // region 月度路线售票率
                MenudTO yueduluxianshoupiaolv = new MenudTO();
                yueduluxianshoupiaolv.setId("c419ee72-f1a9-42b6-9041-80ccd8e40a1b");
                yueduluxianshoupiaolv.setTitle("月度路线售票率");
                yueduluxianshoupiaolv.setUrl("/Modules/ShouPiaoTongJi/YueDuLuXianShouPiaoLv/List.html");
                yueduluxianshoupiaolv.setIcon("glyphicon glyphicon-list-alt");
                List<MenudTO> yueduluxianshoupiaolvSub = new ArrayList<>();
                List<MenudTO> yueduluxianshoupiaolvExt = new ArrayList<>();
                yueduluxianshoupiaolv.setSubMenu(yueduluxianshoupiaolvSub);
                yueduluxianshoupiaolv.setExtends(yueduluxianshoupiaolvExt);
                yueduluxianshoupiaolv.setIsEnabled("True");
                yueduluxianshoupiaolv.setCode("003300210014");
                // endregion
                // region 年度路线售票率
                MenudTO nianduluxianshoupiaolv = new MenudTO();
                nianduluxianshoupiaolv.setId("c419ee72-f1a9-42b6-9041-80ccd8e40a1b");
                nianduluxianshoupiaolv.setTitle("年度路线售票率");
                nianduluxianshoupiaolv.setUrl("/Modules/ShouPiaoTongJi/NianDuLuXianShouPiaoLv/List.html");
                nianduluxianshoupiaolv.setIcon("glyphicon glyphicon-list-alt");
                List<MenudTO> nianduluxianshoupiaolvSub = new ArrayList<>();
                List<MenudTO> nianduluxianshoupiaolvExt = new ArrayList<>();
                nianduluxianshoupiaolv.setSubMenu(nianduluxianshoupiaolvSub);
                nianduluxianshoupiaolv.setExtends(nianduluxianshoupiaolvExt);
                nianduluxianshoupiaolv.setIsEnabled("True");
                nianduluxianshoupiaolv.setCode("003300210014");
                // endregion
                // region 购票方式饼图
                MenudTO goupiaofangshibingtu = new MenudTO();
                goupiaofangshibingtu.setId("c419ee72-f1a9-42b6-9041-80ccd8e40a1b");
                goupiaofangshibingtu.setTitle("购票方式饼图");
                goupiaofangshibingtu.setUrl("/Modules/ShouPiaoTongJi/GouPiaoFangShiBingTu/List.html");
                goupiaofangshibingtu.setIcon("glyphicon glyphicon-list-alt");
                List<MenudTO> goupiaofangshibingtuSub = new ArrayList<>();
                List<MenudTO> goupiaofangshibingtuExt = new ArrayList<>();
                goupiaofangshibingtu.setSubMenu(goupiaofangshibingtuSub);
                goupiaofangshibingtu.setExtends(goupiaofangshibingtuExt);
                goupiaofangshibingtu.setIsEnabled("True");
                goupiaofangshibingtu.setCode("003300210014");
                // endregion
                // region 客车出勤统计
                MenudTO kechechuqintongji = new MenudTO();
                kechechuqintongji.setId("c419ee72-f1a9-42b6-9041-80ccd8e40a1b");
                kechechuqintongji.setTitle("客车出勤统计");
                kechechuqintongji.setUrl("/Modules/ShouPiaoTongJi/KeCheChuQinTongJi/List.html");
                kechechuqintongji.setIcon("glyphicon glyphicon-list-alt");
                List<MenudTO> kechechuqintongjiSub = new ArrayList<>();
                List<MenudTO> kechechuqintongjiExt = new ArrayList<>();
                kechechuqintongji.setSubMenu(kechechuqintongjiSub);
                kechechuqintongji.setExtends(kechechuqintongjiExt);
                kechechuqintongji.setIsEnabled("True");
                kechechuqintongji.setCode("003300210014");
                // endregion
                MenudTO shoupiaotongji = new MenudTO();
                shoupiaotongji.setId("c419ee72-f1a9-42b6-9041-80ccd8e40a1b");
                shoupiaotongji.setTitle("售票统计");
                shoupiaotongji.setUrl("/");
                shoupiaotongji.setIcon("glyphicon glyphicon-list-alt");
                List<MenudTO> shoupiaotongjiSub = new ArrayList<>();
                List<MenudTO> shoupiaotongjiExt = new ArrayList<>();
                shoupiaotongjiSub.add(yueduluxianshoupiaolv);
                shoupiaotongjiSub.add(nianduluxianshoupiaolv);
                shoupiaotongjiSub.add(goupiaofangshibingtu);
                shoupiaotongjiSub.add(kechechuqintongji);
                shoupiaotongji.setSubMenu(shoupiaotongjiSub);
                shoupiaotongji.setExtends(shoupiaotongjiExt);
                shoupiaotongji.setIsEnabled("True");
                shoupiaotongji.setCode("003300210014");
                // endregion

                MenudTO guanligongneng = new MenudTO();
                guanligongneng.setId("678bda20-b992-43df-afc0-e1343ff8d44a");
                guanligongneng.setTitle("管理功能");
                guanligongneng.setUrl("/");
                guanligongneng.setIcon("glyphicon glyphicon-list-alt");
                List<MenudTO> guanligongnengSub = new ArrayList<>();
                guanligongnengSub.add(jichudangan);
                guanligongnengSub.add(banciguanli);
                guanligongnengSub.add(shoupiaotongji);
                List<MenudTO> guanligongnengExt = new ArrayList<>();
                guanligongneng.setSubMenu(guanligongnengSub);
                guanligongneng.setExtends(guanligongnengExt);
                guanligongneng.setIsEnabled("True");
                guanligongneng.setCode("003300210024");

                MenudTO menudTO = new MenudTO();
                List<MenudTO> menudTOSub = new ArrayList<>();
                List<MenudTO> menudTOExt = new ArrayList<>();
                menudTOSub.add(guanligongneng);
                menudTO.setSubMenu(menudTOSub);
                menudTO.setExtends(menudTOExt);
                // endregion
                response = LYQResponse.createBySuccess(menudTO);
                break;
            }
            case 1:{
                // region 省级管理部门的菜单
                // region 基础档案
                // region 监管部门信息
                // region 市级监管部门
                MenudTO shiji = new MenudTO();
                shiji.setId("c419ee72-f1a9-42b6-9041-80ccd8e40a1b");
                shiji.setTitle("市级");
                shiji.setUrl("/Modules/JiChuDangAn/ShiJiJianGuanBuMen/List.html");
                shiji.setIcon("glyphicon glyphicon-list-alt");
                List<MenudTO> shijiSub = new ArrayList<>();
                List<MenudTO> shijiExt = new ArrayList<>();
                shiji.setSubMenu(shijiSub);
                shiji.setExtends(shijiExt);
                shiji.setIsEnabled("True");
                shiji.setCode("003300210014");
                // endregion

                MenudTO jianguanbumen = new MenudTO();
                jianguanbumen.setId("c419ee72-f1a9-42b6-9041-80ccd8e40a1b");
                jianguanbumen.setTitle("监管部门信息");
                jianguanbumen.setUrl("/");
                jianguanbumen.setIcon("glyphicon glyphicon-list-alt");
                List<MenudTO> jianguanbumenSub = new ArrayList<>();
                List<MenudTO> jianguanbumenExt = new ArrayList<>();
                jianguanbumenSub.add(shiji);
                jianguanbumen.setSubMenu(jianguanbumenSub);
                jianguanbumen.setExtends(jianguanbumenExt);
                jianguanbumen.setIsEnabled("True");
                jianguanbumen.setCode("003300210014");
                // endregion
                // region 客运站信息
                MenudTO keyunzhan = new MenudTO();
                keyunzhan.setId("c419ee72-f1a9-42b6-9041-80ccd8e40a1b");
                keyunzhan.setTitle("客运站信息");
                keyunzhan.setUrl("/Modules/JiChuDangAn/KeYunZhanXinXi/List.html");
                keyunzhan.setIcon("glyphicon glyphicon-list-alt");
                List<MenudTO> keyunzhanSub = new ArrayList<>();
                List<MenudTO> keyunzhanExt = new ArrayList<>();
                keyunzhan.setSubMenu(keyunzhanSub);
                keyunzhan.setExtends(keyunzhanExt);
                keyunzhan.setIsEnabled("True");
                keyunzhan.setCode("003300210014");
                // endregion
                // region 客运企业信息
                MenudTO keyunqiye = new MenudTO();
                keyunqiye.setId("c419ee72-f1a9-42b6-9041-80ccd8e40a1b");
                keyunqiye.setTitle("客运企业信息");
                keyunqiye.setUrl("/Modules/JiChuDangAn/KeYunQiYeXinXi/List.html");
                keyunqiye.setIcon("glyphicon glyphicon-list-alt");
                List<MenudTO> keyunqiyeSub = new ArrayList<>();
                List<MenudTO> keyunqiyeExt = new ArrayList<>();
                keyunqiye.setSubMenu(keyunqiyeSub);
                keyunqiye.setExtends(keyunqiyeExt);
                keyunqiye.setIsEnabled("True");
                keyunqiye.setCode("003300210014");
                // endregion
                // region 客运车队信息
                MenudTO keyunchedui = new MenudTO();
                keyunchedui.setId("c419ee72-f1a9-42b6-9041-80ccd8e40a1b");
                keyunchedui.setTitle("客运车队信息");
                keyunchedui.setUrl("/Modules/JiChuDangAn/KeYunCheDuiXinXi/List.html");
                keyunchedui.setIcon("glyphicon glyphicon-list-alt");
                List<MenudTO> keyuncheduiSub = new ArrayList<>();
                List<MenudTO> keyuncheduiExt = new ArrayList<>();
                keyunchedui.setSubMenu(keyuncheduiSub);
                keyunchedui.setExtends(keyuncheduiExt);
                keyunchedui.setIsEnabled("True");
                keyunchedui.setCode("003300210014");
                // endregion
                // region 客车信息
                MenudTO keche = new MenudTO();
                keche.setId("c419ee72-f1a9-42b6-9041-80ccd8e40a1b");
                keche.setTitle("客车信息");
                keche.setUrl("/Modules/JiChuDangAn/KeCheXinXi/List.html");
                keche.setIcon("glyphicon glyphicon-list-alt");
                List<MenudTO> kecheSub = new ArrayList<>();
                List<MenudTO> kecheExt = new ArrayList<>();
                keche.setSubMenu(kecheSub);
                keche.setExtends(kecheExt);
                keche.setIsEnabled("True");
                keche.setCode("003300210014");
                // endregion
                // region 服务区信息
                MenudTO fuwuqu = new MenudTO();
                fuwuqu.setId("c419ee72-f1a9-42b6-9041-80ccd8e40a1b");
                fuwuqu.setTitle("服务区信息");
                fuwuqu.setUrl("/Modules/JiChuDangAn/FuWuQuXinXi/List.html");
                fuwuqu.setIcon("glyphicon glyphicon-list-alt");
                List<MenudTO> fuwuquSub = new ArrayList<>();
                List<MenudTO> fuwuquExt = new ArrayList<>();
                fuwuqu.setSubMenu(fuwuquSub);
                fuwuqu.setExtends(fuwuquExt);
                fuwuqu.setIsEnabled("True");
                fuwuqu.setCode("003300210014");
                // endregion
                MenudTO jichudangan = new MenudTO();
                jichudangan.setId("d8fba846-971f-4f80-8dd4-da0213390416");
                jichudangan.setTitle("基础档案");
                jichudangan.setUrl("/");
                jichudangan.setIcon("glyphicon glyphicon-list-alt");
                List<MenudTO> jichudanganSub = new ArrayList<>();
                jichudanganSub.add(jianguanbumen);
                jichudanganSub.add(keyunzhan);
                jichudanganSub.add(keyunqiye);
                jichudanganSub.add(keyunchedui);
                jichudanganSub.add(keche);
                jichudanganSub.add(fuwuqu);
                List<MenudTO> jichudanganExt = new ArrayList<>();
                jichudangan.setSubMenu(jichudanganSub);
                jichudangan.setExtends(jichudanganExt);
                jichudangan.setIsEnabled("True");
                jichudangan.setCode("003300210013");
                // endregion
                // region 班次管理
                // region 班车查询
                MenudTO banchechaxun = new MenudTO();
                banchechaxun.setId("c419ee72-f1a9-42b6-9041-80ccd8e40a1b");
                banchechaxun.setTitle("班车查询");
                banchechaxun.setUrl("/Modules/BanCiGuanLi/BanCheChaXun/List.html");
                banchechaxun.setIcon("glyphicon glyphicon-list-alt");
                List<MenudTO> banchechaxunSub = new ArrayList<>();
                List<MenudTO> banchechaxunExt = new ArrayList<>();
                banchechaxun.setSubMenu(banchechaxunSub);
                banchechaxun.setExtends(banchechaxunExt);
                banchechaxun.setIsEnabled("True");
                banchechaxun.setCode("003300210014");
                // endregion
                // region 包车查询
                MenudTO baochechaxun = new MenudTO();
                baochechaxun.setId("c419ee72-f1a9-42b6-9041-80ccd8e40a1b");
                baochechaxun.setTitle("包车查询");
                baochechaxun.setUrl("/Modules/BanCiGuanLi/BaoCheChaXun/List.html");
                baochechaxun.setIcon("glyphicon glyphicon-list-alt");
                List<MenudTO> baochechaxunSub = new ArrayList<>();
                List<MenudTO> baochechaxunExt = new ArrayList<>();
                baochechaxun.setSubMenu(baochechaxunSub);
                baochechaxun.setExtends(baochechaxunExt);
                baochechaxun.setIsEnabled("True");
                baochechaxun.setCode("003300210014");
                // endregion
                // region 路线管理
                MenudTO luxianguanli = new MenudTO();
                luxianguanli.setId("c419ee72-f1a9-42b6-9041-80ccd8e40a1b");
                luxianguanli.setTitle("路线管理");
                luxianguanli.setUrl("/Modules/BanCiGuanLi/LuXianGuanLi/List.html");
                luxianguanli.setIcon("glyphicon glyphicon-list-alt");
                List<MenudTO> luxianguanliSub = new ArrayList<>();
                List<MenudTO> luxianguanliExt = new ArrayList<>();
                luxianguanli.setSubMenu(luxianguanliSub);
                luxianguanli.setExtends(luxianguanliExt);
                luxianguanli.setIsEnabled("True");
                luxianguanli.setCode("003300210014");
                // endregion
                // region 客运排班
                MenudTO keyunpaiban = new MenudTO();
                keyunpaiban.setId("c419ee72-f1a9-42b6-9041-80ccd8e40a1b");
                keyunpaiban.setTitle("客运排班");
                keyunpaiban.setUrl("/Modules/BanCiGuanLi/KeYunPaiBan/List.html");
                keyunpaiban.setIcon("glyphicon glyphicon-list-alt");
                List<MenudTO> keyunpaibanSub = new ArrayList<>();
                List<MenudTO> keyunpaibanExt = new ArrayList<>();
                keyunpaiban.setSubMenu(keyunpaibanSub);
                keyunpaiban.setExtends(keyunpaibanExt);
                keyunpaiban.setIsEnabled("True");
                keyunpaiban.setCode("003300210014");
                // endregion
                // region 客车班次查询
                MenudTO kechebancichaxun = new MenudTO();
                kechebancichaxun.setId("c419ee72-f1a9-42b6-9041-80ccd8e40a1b");
                kechebancichaxun.setTitle("客车班次查询");
                kechebancichaxun.setUrl("/Modules/BanCiGuanLi/KeCheBanCi/List.html");
                kechebancichaxun.setIcon("glyphicon glyphicon-list-alt");
                List<MenudTO> kechebancichaxunSub = new ArrayList<>();
                List<MenudTO> kechebancichaxunExt = new ArrayList<>();
                kechebancichaxun.setSubMenu(kechebancichaxunSub);
                kechebancichaxun.setExtends(kechebancichaxunExt);
                kechebancichaxun.setIsEnabled("True");
                kechebancichaxun.setCode("003300210014");
                // endregion
                MenudTO banciguanli = new MenudTO();
                banciguanli.setId("c419ee72-f1a9-42b6-9041-80ccd8e40a1b");
                banciguanli.setTitle("班次管理");
                banciguanli.setUrl("/");
                banciguanli.setIcon("glyphicon glyphicon-list-alt");
                List<MenudTO> banciguanliSub = new ArrayList<>();
                List<MenudTO> banciguanliExt = new ArrayList<>();
                banciguanliSub.add(banchechaxun);
                banciguanliSub.add(baochechaxun);
                banciguanliSub.add(luxianguanli);
                banciguanliSub.add(keyunpaiban);
                banciguanliSub.add(kechebancichaxun);
                banciguanli.setSubMenu(banciguanliSub);
                banciguanli.setExtends(banciguanliExt);
                banciguanli.setIsEnabled("True");
                banciguanli.setCode("003300210014");
                // endregion
                // region 售票统计
                // region 月度路线售票率
                MenudTO yueduluxianshoupiaolv = new MenudTO();
                yueduluxianshoupiaolv.setId("c419ee72-f1a9-42b6-9041-80ccd8e40a1b");
                yueduluxianshoupiaolv.setTitle("月度路线售票率");
                yueduluxianshoupiaolv.setUrl("/Modules/ShouPiaoTongJi/YueDuLuXianShouPiaoLv/List.html");
                yueduluxianshoupiaolv.setIcon("glyphicon glyphicon-list-alt");
                List<MenudTO> yueduluxianshoupiaolvSub = new ArrayList<>();
                List<MenudTO> yueduluxianshoupiaolvExt = new ArrayList<>();
                yueduluxianshoupiaolv.setSubMenu(yueduluxianshoupiaolvSub);
                yueduluxianshoupiaolv.setExtends(yueduluxianshoupiaolvExt);
                yueduluxianshoupiaolv.setIsEnabled("True");
                yueduluxianshoupiaolv.setCode("003300210014");
                // endregion
                // region 年度路线售票率
                MenudTO nianduluxianshoupiaolv = new MenudTO();
                nianduluxianshoupiaolv.setId("c419ee72-f1a9-42b6-9041-80ccd8e40a1b");
                nianduluxianshoupiaolv.setTitle("年度路线售票率");
                nianduluxianshoupiaolv.setUrl("/Modules/ShouPiaoTongJi/NianDuLuXianShouPiaoLv/List.html");
                nianduluxianshoupiaolv.setIcon("glyphicon glyphicon-list-alt");
                List<MenudTO> nianduluxianshoupiaolvSub = new ArrayList<>();
                List<MenudTO> nianduluxianshoupiaolvExt = new ArrayList<>();
                nianduluxianshoupiaolv.setSubMenu(nianduluxianshoupiaolvSub);
                nianduluxianshoupiaolv.setExtends(nianduluxianshoupiaolvExt);
                nianduluxianshoupiaolv.setIsEnabled("True");
                nianduluxianshoupiaolv.setCode("003300210014");
                // endregion
                // region 购票方式饼图
                MenudTO goupiaofangshibingtu = new MenudTO();
                goupiaofangshibingtu.setId("c419ee72-f1a9-42b6-9041-80ccd8e40a1b");
                goupiaofangshibingtu.setTitle("购票方式饼图");
                goupiaofangshibingtu.setUrl("/Modules/ShouPiaoTongJi/GouPiaoFangShiBingTu/List.html");
                goupiaofangshibingtu.setIcon("glyphicon glyphicon-list-alt");
                List<MenudTO> goupiaofangshibingtuSub = new ArrayList<>();
                List<MenudTO> goupiaofangshibingtuExt = new ArrayList<>();
                goupiaofangshibingtu.setSubMenu(goupiaofangshibingtuSub);
                goupiaofangshibingtu.setExtends(goupiaofangshibingtuExt);
                goupiaofangshibingtu.setIsEnabled("True");
                goupiaofangshibingtu.setCode("003300210014");
                // endregion
                // region 客车出勤统计
                MenudTO kechechuqintongji = new MenudTO();
                kechechuqintongji.setId("c419ee72-f1a9-42b6-9041-80ccd8e40a1b");
                kechechuqintongji.setTitle("客车出勤统计");
                kechechuqintongji.setUrl("/Modules/ShouPiaoTongJi/KeCheChuQinTongJi/List.html");
                kechechuqintongji.setIcon("glyphicon glyphicon-list-alt");
                List<MenudTO> kechechuqintongjiSub = new ArrayList<>();
                List<MenudTO> kechechuqintongjiExt = new ArrayList<>();
                kechechuqintongji.setSubMenu(kechechuqintongjiSub);
                kechechuqintongji.setExtends(kechechuqintongjiExt);
                kechechuqintongji.setIsEnabled("True");
                kechechuqintongji.setCode("003300210014");
                // endregion
                MenudTO shoupiaotongji = new MenudTO();
                shoupiaotongji.setId("c419ee72-f1a9-42b6-9041-80ccd8e40a1b");
                shoupiaotongji.setTitle("售票统计");
                shoupiaotongji.setUrl("/");
                shoupiaotongji.setIcon("glyphicon glyphicon-list-alt");
                List<MenudTO> shoupiaotongjiSub = new ArrayList<>();
                List<MenudTO> shoupiaotongjiExt = new ArrayList<>();
                shoupiaotongjiSub.add(yueduluxianshoupiaolv);
                shoupiaotongjiSub.add(nianduluxianshoupiaolv);
                shoupiaotongjiSub.add(goupiaofangshibingtu);
                shoupiaotongjiSub.add(kechechuqintongji);
                shoupiaotongji.setSubMenu(shoupiaotongjiSub);
                shoupiaotongji.setExtends(shoupiaotongjiExt);
                shoupiaotongji.setIsEnabled("True");
                shoupiaotongji.setCode("003300210014");
                // endregion

                MenudTO guanligongneng = new MenudTO();
                guanligongneng.setId("678bda20-b992-43df-afc0-e1343ff8d44a");
                guanligongneng.setTitle("管理功能");
                guanligongneng.setUrl("/");
                guanligongneng.setIcon("glyphicon glyphicon-list-alt");
                List<MenudTO> guanligongnengSub = new ArrayList<>();
                guanligongnengSub.add(jichudangan);
                guanligongnengSub.add(banciguanli);
                guanligongnengSub.add(shoupiaotongji);
                List<MenudTO> guanligongnengExt = new ArrayList<>();
                guanligongneng.setSubMenu(guanligongnengSub);
                guanligongneng.setExtends(guanligongnengExt);
                guanligongneng.setIsEnabled("True");
                guanligongneng.setCode("003300210024");

                MenudTO menudTO = new MenudTO();
                List<MenudTO> menudTOSub = new ArrayList<>();
                List<MenudTO> menudTOExt = new ArrayList<>();
                menudTOSub.add(guanligongneng);
                menudTO.setSubMenu(menudTOSub);
                menudTO.setExtends(menudTOExt);
                // endregion
                response = LYQResponse.createBySuccess(menudTO);
                break;
            }
            case 2:{
                break;
            }
            case 3:{
                break;
            }
            case 4:{
                break;
            }
            case 5:{
                break;
            }
        }
        return response;
    }
}