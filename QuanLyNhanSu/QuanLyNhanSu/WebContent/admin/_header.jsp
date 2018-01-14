<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<div id="header">
      <div style="width: 100%">
        <h1>TRƯỜNG ĐẠI HỌC BÁCH KHOA - ĐẠI HỌC ĐÀ NẴNG</h1>
      </div>
    </div>
    <div class="nav-side-menu">
      <div class="brand">*^_^* MENU *^_^*</div>
      <i class="fa fa-bars fa-2x toggle-btn" data-toggle="collapse" data-target="#menu-content"></i>
      <div class="menu-list">
        <ul id="menu-content" class="menu-content collapse out">
          <li>
            <a href="/QuanLyNhanSu/inforuser?action=getUser">
            <i class="fa fa-dashboard fa-lg"></i> Home
            </a>
          </li>
          <li>
            <a href="/QuanLyNhanSu/inforuser?action=new&userType=teacher">
            <i class="fa fa-users fa-lg"></i> Add Teacher
            </a>
          </li>
          <li>
            <a href="/QuanLyNhanSu/inforuser?action=new&userType=staff">
            <i class="fa fa-users fa-lg"></i> Add Staff
            </a>
          </li>
          </li>
          <ul class="sub-menu collapse" id="new">
            <li>Infor</li>
            <li>Edit Infor</li>
            <li>Edit user and password</li>
          </ul>
          <li>
            <a href="#">
            <i class="fa fa-users fa-lg"></i> Logout
            </a>
          </li>
        </ul>
      </div>
    </div>