package com.chanhue.nbcamp_assignment

import android.os.Parcelable
import androidx.versionedparcelable.VersionedParcelize
import kotlinx.parcelize.Parcelize

@Parcelize
data class MyItem(
    val imageFileName: Int,      // 이미지 파일명
    val productName: String,        // 상품명
    val productDescription: String, // 상품 소개
    val seller: String,             // 판매자
    val price: Int,                 // 가격
    val address: String,            // 주소
    val likes: Int,                 // 좋아요 수
    val chatCount: Int,              // 채팅 수

):Parcelable
