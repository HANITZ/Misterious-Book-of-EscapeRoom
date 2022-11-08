import React, { useEffect, useState } from "react";
import { FlatList, Text, View, useWindowDimensions } from "react-native";
import { TabView, SceneMap, TabBar } from "react-native-tab-view";
import styled from "styled-components/native";
import Ionicons from "@expo/vector-icons/Ionicons";

import { useQuery } from "@tanstack/react-query";
import { searchApi } from "../apis/api";

import LoadingScreen from "./LoadingScreen";
import SearchThemeList from "../components/SearchThemeList";

function CafeDetailScreen({ navigation: { navigate }, route }) {
  const { storeId } = route.params;
  const { isLoading, status, data } = useQuery(
    ["CafeDetail", storeId], //토큰 추가
    searchApi.getCafeDetail
  );

  const HeaderTabView = () => {
    const FirstRoute = () => (
      <FlatList
        data={data?.themeDetailDtoList}
        showsVerticalScrollIndicator={false}
        contentContainerStyle={{ 
          paddingTop: 40,
          marginHorizontal: 20
        }}
        renderItem={({ item }) => (
          <SearchThemeList
            themeId={item.themeId}
            themeName={item.themeName}
            storeName={item.storeName}
            themeImg={item.themeImg}
            likeCount={item.likeCount}
            star={item.star}
          />
        )}
      />
    );

    const SecondRoute = () => (
      <View style={{ flex: 1, backgroundColor: "#673ab7" }}>
        <Ionicons name="call" size={24} color="black" />
        <Text>전화 하기</Text>
        <Ionicons name="logo-instagram" size={24} color="black" />
        <Text>방문 하기</Text>
        <Text>지도 띄우기</Text>
      </View>
    );

    const renderScene = SceneMap({
      first: FirstRoute,
      second: SecondRoute,
    });
    const layout = useWindowDimensions();

    const [index, setIndex] = React.useState(0);
    const [routes] = React.useState([
      { key: "first", title: "테마 종류" },
      { key: "second", title: "상세 정보" },
    ]);

    return (
      <TabView
        navigationState={{ index, routes }}
        renderScene={renderScene}
        onIndexChange={setIndex}
        initialLayout={{ width: layout.width }}
        renderTabBar={(props) => (
          <TabBar {...props} style={{ backgroundColor: null }} />
        )}
      />
    );
  };

  return status === 'success' ? (
    <>
      <Container>
        {/* themeImg 넣기 */}
        <CafeImage />
        <TextContainer>
          <Title>{data.storeName}</Title>
          <SubTitle>{data.Address}</SubTitle>
          <SubTitle>{data.mapX}</SubTitle>
          <SubTitle>{data.mapY}</SubTitle>

          <SubTitle>{data.tel}분 | </SubTitle>
          <SubTitle>난이도 {data.storeImg} | </SubTitle>
          <SubTitle>{data.homepage} </SubTitle>

          <SubTitle>{data.region}</SubTitle>
          <SubTitle>{data.clearCnt} / {data.totalTheme}</SubTitle>
        </TextContainer>
      </Container>
      <HeaderTabView />
    </>
  ) : (
    <LoadingScreen />
  );
}

const Container = styled.View`
  flex-direction: row;
  margin-bottom: 16px;
  align-items: center;
`;

const TextContainer = styled.View`
  margin-left: 16px;
`;

// 추후 이미지 태그로 대체
const CafeImage = styled.View`
  width: 100px;
  height: 160px;
  background-color: gray;
`;
const Title = styled.Text`
  font-family: "SUIT-SemiBold";
  font-size: ${({ theme }) => theme.fontSizes.body};
  color: #fff;
  margin-bottom: 8px;
`;
const SubTitle = styled.Text`
  font-family: "SUIT-Bold";
  font-size: ${({ theme }) => theme.fontSizes.caption1};
  color: #fff;
`;

const TmpContainer = styled.View`
  background-color: #fff;
`;

export default CafeDetailScreen;