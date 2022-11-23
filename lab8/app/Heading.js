import { StyleSheet, Text, View } from 'react-native';

export default function Heading() {
  return <Text style={styles.heading}>Hello World!</Text>;
}

const styles = StyleSheet.create({
  heading: {
    color: 'red',
    textAlign: 'center',
    fontSize: 30,
  },
});
