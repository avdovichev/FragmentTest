# FragmentTest

Currently this project is dedicated to research problem
when onConfigurationChanged function is invoked for fragment
which is in back stack and which view was destroyed.

Application structure:
MainActivity - main activity that hosts fragments
FirstFragment - fragment with tab layout that hosts SectionFragment instances
SecondFragment - empty fragment that is used to replace FirstFragment and make views of FirstFragment and all SectionFragment instances destroyed
SectionFragment - instances of this fragment are childen of tab layout of FirstFragment

How to reproduce crash:
1. Launch app
2. See section fragments in tab layout
3. Click right arrow in action bar to open Second frament
4. See section fragment is opened
5. Rotate device so that screen orientation changed
6. See that application crashed because onConfigurationChanged was called for SecondFragment with destroyed view

You may filter Logcat output for AXFT to get log lines for key lifecycle events
