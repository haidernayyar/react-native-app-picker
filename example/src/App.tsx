import * as React from 'react';

import { StyleSheet, View, Text } from 'react-native';
import { pick } from 'react-native-app-picker';

export default function App() {
  const [result, setResult] = React.useState<Array<string>>([]);

  React.useEffect(() => {
    pick().then(setResult);
  }, []);

  return (
    <View style={styles.container}>
      <Text>Result: {result?.[1]}</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});
