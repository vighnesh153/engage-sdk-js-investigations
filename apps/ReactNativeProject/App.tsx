/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 */

import React, {useEffect} from 'react';
import {
  SafeAreaView,
  StyleProp,
  Text,
  TextStyle,
  ViewStyle,
} from 'react-native';
import {EngageModule, samplePublishContinuationClusterRequest} from './engage';

export default function App(): React.JSX.Element {
  const backgroundStyle: StyleProp<ViewStyle> = {
    backgroundColor: 'yellow',
    width: '100%',
    height: '100%',
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'center',
  };
  const textStyle: StyleProp<TextStyle> = {
    fontSize: 48,
    fontWeight: 'bold',
    color: 'black',
  };

  useEffect(() => {
    setTimeout(() => {
      EngageModule.publishContinuationCluster(
        samplePublishContinuationClusterRequest,
      );
    }, 1000);
  }, []);

  return (
    <SafeAreaView style={backgroundStyle}>
      <Text style={textStyle}>Pikachu</Text>
    </SafeAreaView>
  );
}
