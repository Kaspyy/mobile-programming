import { StatusBar } from 'expo-status-bar';
import { ScrollView, StyleSheet } from 'react-native';
import Heading from './app/Heading';

export default function App() {
  return (
    <ScrollView contentContainerStyle={styles.container}>
      <Heading />
      <StatusBar style='auto' />
    </ScrollView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
