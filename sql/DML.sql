-- [噺据]
insert into member values(member_seq.nextval, 'email1@google.com', '111', '111', '室生艦', '20', 'F', '010-1111-1111', '井奄亀 督爽獣', '壕含', NULL, NULL, NULL, 0, 0);
insert into member values(member_seq.nextval, 'email2@google.com', '222', '222', '奄鉢艦', '30', 'M', '010-2222-2222', '井奄亀 遂昔獣', '短社', NULL, NULL, NULL, 0, 0);
insert into member values(member_seq.nextval, 'email3@google.com', '222', '222', '駁耕艦', '25', 'F', '010-3333-3333', '辞随獣 原匂姥', '宜砂', NULL, NULL, NULL, 0, 0);

-- [宿採硯 去系]
<<<<<<< HEAD
insert into errand values(errand_seq.nextval, 1, '2021-10-11', '郊訂忽傾 説焼 爽叔 歳ばば', '増拭 郊訂忽傾亜 格巷 弦焼推ばば 坦軒 亜管廃 遂切歳 達柔艦陥!', '忽傾', '督爽', '2021-10-11', 1);
insert into errand values(errand_seq.nextval, 2, '2021-10-12', '悪焼走 宜左澗 歳 厭姥!!', '肇切 食楳 亜辞 益訓汽 悪焼走 紫櫛生稽 宜坐爽叔 歳ぞぞ', '宜砂', '遂昔', '2021-10-12', 2); 
insert into errand values(errand_seq.nextval, 3, '2021-10-13', '厭馬惟 辞嫌 穿含背 爽叔 歳!?', '厭廃 闇汽 倖戚 焼督辞 企重 穿含背 爽叔 歳 域叔猿推~', '壕含', '辞随獣 悪辞姥 去談稽39亜掩 15-6', '2021-10-13', 1);
=======
insert into errand values(errand_seq.nextval, 1, 10000, '2021-10-11', '郊訂忽傾 説焼 爽叔 歳ばば', '増拭 郊訂忽傾亜 格巷 弦焼推ばば 坦軒 亜管廃 遂切歳 達柔艦陥!', '忽傾', '督爽', '2021-10-11', 1);
insert into errand values(errand_seq.nextval, 2, 20000, '2021-10-12', '悪焼走 宜左澗 歳 厭姥!!', '肇切 食楳 亜辞 益訓汽 悪焼走 紫櫛生稽 宜坐爽叔 歳ぞぞ', '宜砂', '遂昔', '2021-10-12', 2); 
insert into errand values(errand_seq.nextval, 3, 15000, '2021-10-13', '厭馬惟 辞嫌 穿含背 爽叔 歳!?', '厭廃 闇汽 倖戚 焼督辞 企重 穿含背 爽叔 歳 域叔猿推~', '壕含', '辞随獣 悪辞姥 去談稽39亜掩 15-6', '2021-10-13', 1);
>>>>>>> c2c33aaa3ae721d4cda296d3dd4b658192974d3b

-- [宿採硯 走据]
insert into apply values(apply_seq.nextval, 3, 1, '督爽走蝕 戚暗煽暗 壕含 亜管杯艦陥! 災君爽室推~', '2021-10-14', 0);
insert into apply values(apply_seq.nextval, 1, 2, '短社 貢 乞窮 増照析 位蟹 設杯艦陥ぞぞ', '2021-10-14', 0);
insert into apply values(apply_seq.nextval, 2, 3, '原雁赤澗 穿据爽澱脊艦陥^^鋼形庁姥級引 畷馬惟 号庚馬室推^^', '2021-10-14', 1);

commit;

SELECT * FROM MEMBER;
SELECT * FROM errand;
SELECT * FROM apply;
